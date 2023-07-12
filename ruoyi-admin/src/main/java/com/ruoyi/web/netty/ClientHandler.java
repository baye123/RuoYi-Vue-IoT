package com.ruoyi.web.netty;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.ruoyi.web.util.Analysis_Tokyo;
import com.ruoyi.web.util.MyDecoder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : baye
 * @Date : 2023/3/15 16:37
 * @Code : bug and work
 * @Description : Netty客户端操作类
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {
    public ChannelHandlerContext channelHandlerContext;
    //rabbitmq交换机名称
    private String EXCHANGE_NAME = "direct_Tokyo";

    private String RoutingKey;
    //创建多个 bindingKey
    Map<String, String> bindingKeyMap = new HashMap<>();

    public Channel channel;

    private NettyClient nettyClient;

    private Analysis_Tokyo analysis_tokyo = new Analysis_Tokyo();

    private StringBuilder sb_hex = new StringBuilder();

    private volatile int sumcheck_error_count;

    private MyDecoder myDecoder = new MyDecoder();

    ClientHandler(String exchangeName,String routingKey,NettyClient nettyClient){
        EXCHANGE_NAME = exchangeName;
        RoutingKey = routingKey;
        this.nettyClient = nettyClient;

    }



    /**
     * 活跃通道可以发送消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channelHandlerContext = ctx;
        //channelHandlerContext.writeAndFlush("11111");
        //channelHandlerContext.channel().close();
    }

    /**
     *
     * 通道不活跃时调用
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("断开连接。。。");
//        nettyClient.connect();
    }


    /**
     * 读取消息，其中内置消息过滤过程
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        long rec_time = System.currentTimeMillis();
        try {
            sb_hex.append(msg);//将接收到的数据存入该字符串中。
            label1:
            for (; ; ) {
                int resp_head_index = sb_hex.indexOf("223A222C");//"223A222C"对应ascii: ":", 是数据开始的标志
                if (resp_head_index > -1) {

                    int resp_tail_index;//resp完整数据的末尾结束字符的index,这里的index是指该字符开始的位置
                    int body_head_index = resp_head_index + 6;//body正文内容的开头字符的index,这里的index是指该字符的开始的位置
                    int body_tail_index;//body正文内容的末尾结束字符的index,这里的index是指该字符的开始的位置
                    int resp_tail_end;//resp完整数据的末尾结束字符的end,这里的end是指该字符结束的位置

                    if (sb_hex.length() >= resp_head_index + 12) {//判断是否接收到状态码,如果没接收到状态码就退出本方法,继续接收数据
                        //确定字符
                        //40状态码数据在下面处理
                        if ("3430".equals(sb_hex.substring(resp_head_index + 8, resp_head_index + 12))) {//"3430"对应ascii: 40,这里处理40状态码的数据,也就是面板画面png数据
                            resp_tail_index = sb_hex.indexOf("2C454E440D", resp_head_index + 12);//"2C454E440D"对应ascii: ,END\r 开始查找的位置从":",xx,后面的第二个,逗号开始,包含,逗号字符
                            if (resp_tail_index > -1) {//查找到,END\r
                                resp_tail_end = resp_tail_index + 10;//把resp完整数据截止到,END\r,包含,END\r字符
                                System.out.println("40状态码暂不处理");
                                sb_hex.delete(0, resp_tail_end);//删除已保存的数据
                                continue label1;//继续查找剩下的数据
                            }
                            break;
                            //其他状态码在下面处理
                        } else {
                            int from_index = resp_head_index + 12;//开始查找的位置从":",xx,后面的第二个,逗号开始,包含,逗号字符
                            label2:
                            for (; ; ) {//开始查找正确的0D字符
                                resp_tail_index = sb_hex.indexOf("0D", from_index);//ascii: \r
                                if (resp_tail_index > -1) {//查找到0D字符
                                    if ((resp_tail_index & 1) == 0) {//判断该0D的位置index是否是偶数,以确定获取到的0D是否是一个单独的字符, 还是前后的16进制字符刚好形成0D字符
                                        if (sb_hex.substring(resp_tail_index - 6, resp_tail_index - 4).equals("2C")) {//检测校验码前两位是否是2C,逗号
                                            body_tail_index = resp_tail_index - 4;//是的话就说明该0D字符是正确的,然后把body正文内容截止到逗号,包含逗号字符
                                            if (this.analysis_tokyo.check_sum_8bit(sb_hex, body_head_index, body_tail_index, resp_tail_index)) {//判断校验码是否正确,正确就保存
                                                resp_tail_end = resp_tail_index + 2;//把resp完整的数据截止到0D,包含0D字符
                                                byte[] data = this.analysis_tokyo.saveResp(sb_hex, resp_head_index, resp_tail_end, rec_time);
                                                channel.basicPublish(EXCHANGE_NAME, RoutingKey, MessageProperties.PERSISTENT_TEXT_PLAIN, data);
                                                System.out.println("生产者发出消息:" + myDecoder.bytesToHexString(data));
                                                sb_hex.delete(0, resp_tail_end);//删除已保存的数据
                                                continue label1;//回到主循环,继续查找是否还有数据
                                            } else {//校验码有误,退出本方法,继续接受数据,可能是该数据接收不完整
                                                System.out.println("校验码有误");
                                                sumcheck_error_count = sumcheck_error_count + 1;
                                                if (sumcheck_error_count >= 2) {
                                                    sb_hex.delete(0, resp_tail_index + 2);//连续两次都是校验码有误,那就删除该部分数据
                                                    sumcheck_error_count = 0;
                                                }
                                                break label1;
                                            }
                                        } else {//校验码前无2C,无逗号情况,就说明这个0D应该不是结束字符, 要跳过这个0D
                                            from_index = resp_tail_index + 2;//开始查找的位置往前移动2
                                            continue label2;
                                        }
                                    } else {
                                        from_index = resp_tail_index + 1;
                                        continue label2;
                                    }
                                } else {//不存在0D字符,退出本方法
                                    break label1;
                                }
                            }
                        }

                    } else {//如果没接收到状态码就退出本方法,继续接收数据
                        break;
                    }

                }
                break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Netty客户端接收消息：" + msg);
    }





}

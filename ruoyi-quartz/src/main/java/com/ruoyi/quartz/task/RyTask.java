package com.ruoyi.quartz.task;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.ruoyi.quartz.domain.AgreementVo;
import com.ruoyi.quartz.domain.Message;
import com.ruoyi.quartz.service.AgreementVoService;
import com.ruoyi.quartz.service.MessageService;
import com.ruoyi.quartz.util.Analysis;
import com.ruoyi.quartz.util.RabbitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{
    @Autowired
    AgreementVoService agreementVoService;
    @Autowired
    MessageService messageService;

    //解析命令的方法对象
    private Analysis analysis = new Analysis();

//    //消息数据存储的实体类对象
//    private Message message =new Message();
//    //计算合模状态时间
//    private String t1 = "0.0s";

    //计算周期使用的队列对象 30位
//    private ArrayDeque arrayDeque = new ArrayDeque(30);


    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法啊啊啊");
    }

    public void RabbitMQConsumer(){
        List<AgreementVo> agreementVoList = agreementVoService.getAgreementVoList();
        String ip ="";
        int status = 0;





            for (AgreementVo agreementVo : agreementVoList) {
                ip = agreementVo.getIp();
                status = agreementVo.getAgreement_status();
                ArrayDeque arrayDeque = new ArrayDeque(30); //用于计算合模周期的队列
                ArrayDeque arrayDeque2 = new ArrayDeque(30); //保留先前的合模周期的队列
                ArrayDeque arrayDeque3 = new ArrayDeque(30); //用于计算合模周期的队列
                ArrayDeque arrayDeque4 = new ArrayDeque(30); //保留先前的合模周期的队列
                AtomicReference<Integer> t1 = new AtomicReference<Integer>();
                AtomicReference<Integer> t2 = new AtomicReference<Integer>();
                arrayDeque2.add(0);
                arrayDeque4.add(0);
                if(status == 0){
                    continue;
                }
                System.out.println(ip);
                try {
                    Channel channel = RabbitUtil.getChannel();
                    RabbitUtil rabbitUtil = new RabbitUtil();
                    rabbitUtil.channelReceive(channel, "direct_IoT", ip, ip);
                    System.out.println("绑定成功？");

                    // RabbitMQ收到消息的回调接口
                    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                        String message2 = new String(delivery.getBody(), "UTF-8");
                        System.out.println(" 接收绑定键 :" + delivery.getEnvelope().getRoutingKey() + ", 消息:" + message2);
                        Message message = new Message();


                        //当前时间
                        message.setTime(analysis.cutmsg(message2));
                        message.setTime_stamp(analysis.cutmsg2(message2));

                        //切割时间后的消息
                        String news =analysis.getNews();
                        message.setOriginal_information(news);
                        //解析消息后的位图 也是解析消息后的设备状态值
                        String[] bitmap =analysis.hexToIntarray(news);
                        String str =(Arrays.toString(bitmap));
                        message.setStatus_value(str);
                        //解析消息后的设备ID
                        String ID = analysis.getEquipmentId(news);
                        message.setIP(ID);
                        //解析消息后的设备表名
                        String IP = delivery.getEnvelope().getRoutingKey();
                        String table = "equipment_" + IP.replace('.','_');
                        message.setTable(table);
                        message.setEquipmentId(IP);
                        //解析消息后的设备安灯状态值
                        message.setLight(analysis.lightStatus(bitmap));
                        //解析消息后的设备各DI通道单独情况
                        message.setDI_1(bitmap[7]);
                        message.setDI_2(bitmap[6]);
                        message.setDI_3(bitmap[5]);
                        message.setDI_4(bitmap[4]);
                        message.setDI_5(bitmap[3]);
                        message.setDI_6(bitmap[2]);
                        message.setDI_7(bitmap[1]);
                        message.setDI_8(bitmap[0]);

                        //合模状态默认为0
                       message.setMold_closing(0);
                       message.setCycle1(0);
                       message.setCycle2(0);
                       message.setCycle3(0);
                        if(Objects.equals(message.getDI_1(), "1")){
                            //计算合模周期
                            arrayDeque.add(message.getTime_stamp());
                            message.setCycle1((int) arrayDeque2.peek());
                            //计算合模间隔
                            if(arrayDeque3.peek() != null){
                                t2.set(analysis.getDistanceTime(message.getTime_stamp(), (Long) arrayDeque3.peek()));
                                arrayDeque4.clear();
                                arrayDeque4.add(t2.get());
                                message.setCycle2(t2.get());
                            }else{
                                t2.set((int) arrayDeque4.peek());
                                message.setCycle2(t2.get());
                            }
                            arrayDeque3.clear();

                        }
                        if(Objects.equals(message.getDI_1(), "0")){
                            //计算合模周期
                            if(arrayDeque.peek() != null){
                                t1.set(analysis.getDistanceTime(message.getTime_stamp(), (Long) arrayDeque.peek()));
                                arrayDeque2.clear();
                                arrayDeque2.add(t1.get());
                                message.setCycle1(t1.get());
                                message.setMold_closing(1);
                            }else{
                                t1.set((int)arrayDeque2.peek());
                                message.setCycle1(t1.get());
                            }
                            arrayDeque.clear();

//                            计算合模间隔
                            arrayDeque3.add(message.getTime_stamp());
                            message.setCycle2((int) arrayDeque4.peek());
                        }
                        //计算大周期
                        if(message.getCycle1() !=0 && message.getCycle2() !=0){
                            int cycle3 = message.getCycle1() + message.getCycle2();
                            message.setCycle3(cycle3);
                        }
                        this.messageService.insertMessage(message);






                    };
                    //接收信息
                    channel.basicConsume(ip, true, deliverCallback, consumerTag -> {
                    });

                }catch (Exception e){
//                    throw new RuntimeException(e);

                }

            }
        System.out.println("3");


    }
}

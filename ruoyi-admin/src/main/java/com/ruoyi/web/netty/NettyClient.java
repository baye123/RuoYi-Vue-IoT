package com.ruoyi.web.netty;

import com.rabbitmq.client.BuiltinExchangeType;
import com.ruoyi.web.domain.PosttingObject;
import com.ruoyi.web.util.MyDecoder;
import com.ruoyi.web.util.MyEncoder;
import com.ruoyi.web.util.RabbitUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @Author : baye
 * @Date : 2023/3/15 17:03
 * @Code : bug and work
 * @Description : Netty客户端实现长连接
 */
public class NettyClient {
    /** 存储用户id和netty连接关系 */
    public static ConcurrentHashMap<String, PosttingObject> concurrentHashMap = new ConcurrentHashMap();
    public ClientHandler clientHandler;

    private Bootstrap bootstrap;

    private NioEventLoopGroup group;

    private String host;
    private int port;

    private String EXCHANG_NAME;
    private String ROUTING_KEY;



    public NettyClient(String exchangName,String routingKey){
        this.EXCHANG_NAME = exchangName;
        this.ROUTING_KEY = routingKey;
    }
    public void initNetty(String userId, String host, int port){
        System.out.println("你好");
        //创建nioEventLoopGroup
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        NettyClient.this.clientHandler = new ClientHandler(EXCHANG_NAME,ROUTING_KEY,NettyClient.this);
                        System.out.println("正在连接中...");
//                        ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                        ch.pipeline().addLast(new StringDecoder());
//                        ch.pipeline().addLast(new StringEncoder());
//                        ch.pipeline().addLast(clientHandler);
                        ChannelPipeline p = ch.pipeline();
//                        p.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
//                        p.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                        p.addLast("decoder", new MyDecoder());
                        p.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                        p.addLast(clientHandler);
                        //Netty连接同时，建立RabbitMQ通道
                        clientHandler.channel = RabbitUtil.getChannel();
                        clientHandler.channel.exchangeDeclare(EXCHANG_NAME, BuiltinExchangeType.DIRECT,true);
                    }
                });

        try {
            this.host = host;
            this.port = port;
//            this.bootstrap = bootstrap;
             // 发起连接
            ChannelFuture sync = bootstrap.connect().sync();
            System.out.println("用户："+userId + "->服务端连接成功...");
            /* // 发送消息
            sync.channel().writeAndFlush(msg);
            System.out.println("消息发送完成");
            // 关闭连接
            sync.channel().close();*/

            // 异步等待关闭连接channel
            // sync.channel().closeFuture().sync();
            // System.out.println("连接已关闭..");
        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //group.shutdownGracefully();
            //System.out.println("优雅关闭连接");
        }

        PosttingObject posttingObject = new PosttingObject();
        posttingObject.setNioEventLoopGroup(group);
        posttingObject.setNettyClient(this);
        concurrentHashMap.put(userId, posttingObject);
    }

    public void connect() throws Exception {
        ChannelFuture cf = bootstrap.connect(host,port);
        System.out.println("->开始服务端连接...");
        cf.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(!future.isSuccess()){
                    //重连交给后端线程执行
                    future.channel().eventLoop().schedule(()->{
                        System.out.println("重连服务端。。。");
                        try {
                            connect();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }, 3000, TimeUnit.MILLISECONDS);
                } else {
                    System.out.println("服务端连接成功！");
                }
            }
        });

        //对通道关闭进行监听
        cf.channel().closeFuture().sync();
    }
    public void send(String message){

        if (!Pattern.matches(".*\r$", message)) {
            message = message + "\r";
        }

        clientHandler.channelHandlerContext.writeAndFlush(message);
    }

    public void stop() throws Exception{
        this.group.shutdownGracefully();
        clientHandler.channel.close();
        clientHandler.channel.getConnection().close();

        System.out.println("Netty-RabbitMQ通信全关闭");
    }
}

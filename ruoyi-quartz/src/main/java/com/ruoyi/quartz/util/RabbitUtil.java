package com.ruoyi.quartz.util;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

/**
 * @Author : baye
 * @Date : 2023/5/24 9:29
 * @Code : bug and work
 * @Description : rabbitMQ配置工具类
 */
public class RabbitUtil {
    public static Channel getChannel() throws Exception {
        // 引入配置文件
//        Properties properties = new Properties();
//        InputStream inputStream = Files.newInputStream(new File("src/main/resources/rabbit-user.properties").toPath());
//        InputStream inputStream = new FileInputStream(new File("ruoyi-quartz/src/main/resources/rabbit-user.properties"));
//        properties.load(inputStream);
//        String host = properties.getProperty("rabbit.host");
//        String username = properties.getProperty("rabbit.username");
//        String password = properties.getProperty("rabbit.password");
        String host = "192.168.1.30";
        String username = "test";
        String password = "test";

        // 连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);

        // 建立连接和信道
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }

    //RabbitMQ接收消息方法
    public void channelReceive(Channel channel,String exchangName,String queueName,String routingKey) throws Exception{
        //声明交换模式
        channel.exchangeDeclare(exchangName, BuiltinExchangeType.DIRECT,true);
        channel.queueDeclare(queueName, true, false, false,null);
//        生成一个队列
//        1.队列名称
//        2.队列里面的消息是否持久化 默认消息存储在内存中
//        3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
//        4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
//        5.其他参数

        // 绑定队列和交换机 交换机通过路由键确认将信息发送到哪个队列
        channel.queueBind(queueName, exchangName, routingKey);

        System.out.println("等待接收消息........... ");
//        // 收到消息的回调接口
//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String message = new String(delivery.getBody(), "UTF-8");
//            System.out.println(" 接收绑定键 :" + delivery.getEnvelope().getRoutingKey() + ", 消息:" + message);
//        };
////         接收信息
//        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
//        });

    }
}

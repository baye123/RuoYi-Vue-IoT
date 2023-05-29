package com.ruoyi.quartz.task;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.ruoyi.quartz.domain.AgreementVo;
import com.ruoyi.quartz.service.AgreementVoService;
import com.ruoyi.quartz.util.RabbitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.io.IOException;
import java.util.List;

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

                        //
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

package com.ruoyi.web.controller.device;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.web.domain.*;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.netty.NettyClient;
import com.ruoyi.web.service.AgreementService;
import com.ruoyi.web.service.TokyoService;
import com.ruoyi.web.util.Analysis_Tokyo;
import com.ruoyi.web.util.RabbitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Author : baye
 * @Date : 2023/7/4 11:19
 * @Code : bug and work
 * @Description : 可配置东洋控制类
 */
@RestController
@RequestMapping("/device/tokyo")
@Component("tokyoTask")
public class TokyoController extends BaseController {
    @Autowired
    TokyoService tokyoService;

    @Autowired
    AgreementService agreementService;

    Analysis_Tokyo analysis_tokyo = new Analysis_Tokyo();

    //绑定ip与Rabbitmq通道
    Map<String, Channel> bindingIpMap = new HashMap<>();
    //绑定东洋IP与Netty客户端通道
    Map<String, NettyClient> bingdingNettyMap = new HashMap<>();

    /**
     * 获取东洋机台数据列表
     */
    @PreAuthorize("@ss.hasPermi('device:tokyo:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tokyo_33 tokyo_33)
    {
//        startPage();
        List<Tokyo_33> tokyo_33List = tokyoService.selectTokyo_33List(tokyo_33);

        return getDataTable(tokyo_33List);
    }
    /**
     * 获取东洋机台46号数据列表
     */
    @PreAuthorize("@ss.hasPermi('device:tokyo:list46')")
    @GetMapping("/list46")
    public TableDataInfo list(Tokyo_46 tokyo_46)
    {
//        startPage();
        List<Tokyo_46> tokyo_46List = tokyoService.selectTokyo_46List(tokyo_46);

        return getDataTable(tokyo_46List);
    }

    @Log(title = "东洋记录", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('device:tokyo:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tokyo_33 tokyo_33)
    {
        List<Tokyo_33> list = tokyoService.selectTokyo_33List2(tokyo_33);
        ExcelUtil<Tokyo_33> util = new ExcelUtil<Tokyo_33>(Tokyo_33.class);
        util.exportExcel(response, list, "东洋记录数据");
    }
    @Log(title = "东洋46记录", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('device:tokyo:export46')")
    @PostMapping("/export46")
    public void export46(HttpServletResponse response, Tokyo_46 tokyo_46)
    {
        List<Tokyo_46> list = tokyoService.selectTokyo_46List2(tokyo_46);
        ExcelUtil<Tokyo_46> util = new ExcelUtil<Tokyo_46>(Tokyo_46.class);
        util.exportExcel(response, list, "东洋46记录数据");
    }


    public void tokyocount() throws Exception{

        String exchangName = "direct_Tokyo";

        List<Agreement> agreementList = agreementService.selectTokyo_AgreementList();

        for(Agreement a : agreementList){

            String ip = a.getIp();
            //如果协议正在运行
            if(bindingIpMap.get(ip) != null){
                //但运行状态提前更改为停用，则关闭通道
                if(a.getAgreement_status().equals("0")){
                    Channel channelEnd = bindingIpMap.get(ip);
                    channelEnd.close();
                    channelEnd.getConnection().close();
                    //Map中移除该协议键值对
                    bindingIpMap.remove(ip);

                }
                //状态不改变，跳出该循环
                continue;
            }
            //协议不在运行，但状态为停用，直接跳过该循环。
            if(a.getAgreement_status().equals("0")){
                continue;
            }

            String queueName = ip;
            String routingKey = ip;
            try{
                Channel channel = RabbitUtil.getChannel();
                RabbitUtil rabbitUtil = new RabbitUtil();
                rabbitUtil.channelReceive(channel,exchangName,queueName,routingKey);
                System.out.println("MQ队列通道绑定成功！");
                //保存已经运行的协议ip和channel
                bindingIpMap.put(ip,channel);
                // 收到消息的回调接口
                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String message = new String(delivery.getBody(), "UTF-8");
                    try {
                        Tokyo_33 tokyo_33 = new Tokyo_33();
                        tokyo_33 = analysis_tokyo.filter(message);
                        if(tokyo_33 != null){
                            String table = "tokyo_" + ip.replace('.','_');
                            tokyo_33.setTable(table);
                            tokyoService.saveTokyo(tokyo_33);
                        }
                        Tokyo_46 tokyo_46 = new Tokyo_46();
                        tokyo_46 = analysis_tokyo.filter46(message);
                        if(tokyo_46 !=null){
                            tokyo_46.setTable("tokyo46_" + ip.replace('.','_'));
                            tokyoService.saveTokyo46(tokyo_46);
                        }

//                System.out.println(" 接收绑定键 :" + delivery.getEnvelope().getRoutingKey() + ", 消息:" + message);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println(" 接收绑定键 :" + delivery.getEnvelope().getRoutingKey() + ", 消息:" + message);
                };
                //         接收信息
                channel.basicConsume(queueName, true, deliverCallback, consumerTag ->{
                });

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //开启Netty客户端接收东洋机数据
    public void tokyoNetty() throws  Exception{

        String exchangName = "direct_Tokyo";

        List<Agreement> agreementList= agreementService.selectTokyo_AgreementList();
        for(Agreement a : agreementList){
            String userId = a.getIp();
            String routingKey = a.getIp();
            String host = a.getIp();
            int port = Integer.parseInt(a.getPort());
            //Netty客户端已经连接
            if(bingdingNettyMap.get(routingKey) !=null){
                //但运行状态提前更改为停用
                if(a.getAgreement_status().equals("0")){
                    NettyClient nettyClientEnd = bingdingNettyMap.get(routingKey);
                    nettyClientEnd.stop();
                    //Map中移除该客户端键值对
                    bingdingNettyMap.remove(routingKey);

                }
                //状态不改变，则连接保持不变。

                continue;
            }
            //协议不在运行，但状态为停用，直接跳过该循环。
            if(a.getAgreement_status().equals("0")){
                continue;
            }

            NettyClient nettyClient =new NettyClient(exchangName,routingKey);
            nettyClient.initNetty(userId,host,port);
            bingdingNettyMap.put(routingKey,nettyClient);

        }
    }

    //给东洋机台主动发送45号消息，返回46号消息
    public void tokyo_send46(){
        for(NettyClient nettyClient : bingdingNettyMap.values()){
            nettyClient.send("\":\",45,C1\r");
        }
    }


}

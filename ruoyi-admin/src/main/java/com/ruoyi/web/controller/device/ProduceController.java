package com.ruoyi.web.controller.device;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.domain.Produce;
import com.ruoyi.web.domain.Shpmachud;
import com.ruoyi.web.domain.vo.Device_to_agreementVo;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.service.DeviceToAgreementService;
import com.ruoyi.web.service.PlanService;
import com.ruoyi.web.service.ProduceService;
import com.ruoyi.web.service.ShpmachudService;
import com.ruoyi.web.util.DateString;
import com.ruoyi.web.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/12 10:42
 * @Code : bug and work
 * @Description : 实时生产控制类
 */
@RestController
@RequestMapping("/device/produce")
@Component("produceTask")
public class ProduceController extends BaseController {

    @Autowired
    private ProduceService produceService;

    @Autowired
    private PlanService planService;

    @Autowired
    private DeviceToAgreementService deviceToAgreementService;

    @Autowired
    private ShpmachudService shpmachudService;


    /**
     * 获取实时生产列表
     */
    @PreAuthorize("@ss.hasPermi('device:produce:list')")
    @GetMapping("/list")
    public TableDataInfo list(Produce produce) {
        startPage();
        List<Produce> produceList = produceService.selectProduceList(produce);
        return getDataTable(produceList);
    }

    //实时更新计算周期于合模次数
    public void updateProductionData() throws Exception {
        long stime = System.currentTimeMillis();
        List<Produce> produceList = produceService.selectProduceList2();
        //当前时间
//        long millisecond = System.currentTimeMillis();
//        String time_now = DateString.millisecondToStringLong(millisecond);

        for (Produce o : produceList) {
            //当前时间
            long millisecond = System.currentTimeMillis();
            String time_now = DateString.millisecondToStringLong(millisecond);
            //确保上模之后才需要计算
            //获取设备id
            String device_id = o.getDevice_id();
            //获取料号
            String product_id = o.getProduct_id();
            //获取节点
            String cpo = o.getCpo();
            //获取plan对象
            PlanVo planVo = planService.selectPlanVoById(product_id,device_id,cpo);
            //获取Shpmachud对象
            Shpmachud shpmachud = shpmachudService.selectShpmachudById(product_id,device_id,cpo);

            //获取设备协议关联对象
            Device_to_agreementVo device_to_agreementVo = deviceToAgreementService.selectDevice_to_agreementVoByDevice_id(device_id);
            if(device_to_agreementVo == null){
                System.out.println("设备："+device_id +"存在问题，可能无协议连接，可能无设备信息。");
                continue;
            }
            //获取设备关联IoT设备ip
            String ip = device_to_agreementVo.getIp();
            //获取设备表名
            String table = "equipment_" + ip.replace('.', '_');
//                o.setTable(table);
            //获取时间段内的合模次数
            String time1 = o.getDotime();
            String time2 = "";
            String time3 = "";
            //有下模时间
            if (o.getEndtime() != null) {
                //判断是否到下模时间，到了则以下模时间为准，未到则以当前时间为准
                time2 = o.getEndtime();
                time3 = Time.CalTime(time1,time2);
            } else {
                //没有下模时间，直接以当前时间计算
                time2 = time_now;
                time3 = Time.CalTime(time1,time2);
            }
            if(shpmachud != null) {
                shpmachud.setDowncls(time3);
            }
            //IoT合模次数
            int mold_number = produceService.getQuantityByTime(table, time1, time2);
            //取数
            String number = o.getWorksheet();
            String[] s = number.split("#");
            int w;
            if(s.length > 1){
                w = Integer.valueOf(s[1]);
            }
            else {
                w = Integer.valueOf(number);
            }


            int quantity = mold_number * w;
            planVo.setActual_production_quantity(quantity);
            //差异数
            int difference_value = Math.abs(o.getNumrp() - quantity);
            planVo.setDifference_value(difference_value);
            //差异率
            DecimalFormat dF = new DecimalFormat("0.00");
            planVo.setDifference_proportion(dF.format((float)difference_value/o.getNumrp()*100) + "%");
            //获取大周期
            if(produceService.getCycle3ByTime(table, time1, time2) == null) {
                planVo.setActual_cycle(0);
            }
            else{
                planVo.setActual_cycle(produceService.getCycle3ByTime(table, time1, time2));
            }



//            System.out.println(o.toString());
            //更新方法//
            planService.updatePlanVo2(planVo);
            if(shpmachud !=null){
            shpmachudService.updateShpmachud2(shpmachud);
            }
        }
        //for结束
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));

    }

    //实时更新计算机台流水总耗时
    public void updateShpmachudData() throws Exception {
        long stime = System.currentTimeMillis();
        List<Shpmachud> shpmachudList = shpmachudService.selectShpmachudList2();
        //当前时间
//        long millisecond = System.currentTimeMillis();
//        String time_now = DateString.millisecondToStringLong(millisecond);

        for (Shpmachud o : shpmachudList) {
            //当前时间
            long millisecond = System.currentTimeMillis();
            String time_now = DateString.millisecondToStringLong(millisecond);
            //获取设备id
            String device_id = o.getDevice_id();
            //获取料号
            String product_id = o.getProduct_id();
            //获取节点
            String cpo = o.getCpo();
            //获取类别
            String cls = o.getCls();
            //获取时间段内的合模次数
            String time1 = o.getDotime();
            String time2 = "";
            String time3 = "";
            //有下模时间
            if (o.getEndtime() != null) {
                //判断是否到下模时间，到了则以下模时间为准，未到则以当前时间为准
                time2 = o.getEndtime();
                time3 = Time.CalTime(time1,time2);
            } else {
                //没有下模时间，直接以当前时间计算
                time2 = time_now;
                time3 = Time.CalTime(time1,time2);
            }
            o.setDowncls(time3);

//            System.out.println(o.toString());
            //更新方法//
            shpmachudService.updateShpmachud2(o);

        }
        //for结束
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));

    }
}

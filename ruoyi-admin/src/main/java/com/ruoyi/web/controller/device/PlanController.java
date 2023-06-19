package com.ruoyi.web.controller.device;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.vo.Device_to_agreementVo;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.service.DeviceToAgreementService;
import com.ruoyi.web.service.InformationService;
import com.ruoyi.web.service.PlanService;
import com.ruoyi.web.util.DateString;
import com.ruoyi.web.util.Time;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/2 15:20
 * @Code : bug and work
 * @Description : 计划生产管理控制层
 */
@RestController
@RequestMapping("/device/plan")
@Component("updateTask")
public class PlanController extends BaseController {
    @Autowired
    private PlanService planService;

    @Autowired
    private DeviceToAgreementService deviceToAgreementService;

    /**
     * 获取计划生产列表
     */
    @PreAuthorize("@ss.hasPermi('device:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlanVo planVo)
    {
        startPage();
        List<PlanVo> planVoList = planService.selectPlanVoList(planVo);
        return getDataTable(planVoList);
    }

    /**
     * 根据产品编号和设备编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:plan:query')")
    @GetMapping(value = "/seek")
    public AjaxResult getInfo(String product_id,String device_id,String cpo)
    {

        return success(planService.selectPlanVoById(product_id,device_id,cpo));
    }

    /**
     * 修改生产计划
     */
    @PreAuthorize("@ss.hasPermi('device:plan:edit')")
    @Log(title = "计划生产管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody PlanVo planVo)
    {
        if (!planService.checkPlanIdUnique(planVo))
        {
            return error("修改生产计划'" + planVo.getProduct_id() + "+" + planVo.getDevice_id() + "'失败，该生产计划已存在");
        }
        return toAjax(planService.updatePlanVo(planVo));
    }
    /**
     * 新增策略详情
     */
    @PreAuthorize("@ss.hasPermi('device:plan:add')")
    @Log(title = "计划生产管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody PlanVo planVo)
    {

        if (!planService.checkPlanIdUnique(planVo))
        {
            return error("新增生产计划'" + planVo.getProduct_id() + "+" + planVo.getDevice_id() + "'失败，该生产计划已存在");
        }

        return toAjax(planService.insertPlanVo(planVo));
    }

    /**
     * 删除数采策略
     */
    //@RequestParam
    @PreAuthorize("@ss.hasPermi('device:plan:remove')")
    @Log(title = "计划生产管理", businessType = BusinessType.DELETE)
    @DeleteMapping(value = "/remove")
    public AjaxResult remove(String[] product_id,String[] device_id,String[] cpo)
    {

        return toAjax(planService.deletePlanVoById(product_id,device_id,cpo));
    }

    public void hello(){
        System.out.println("你好");
    }


    //实时更新计算周期于合模次数
    public void updateProductionData() throws Exception {
        long stime = System.currentTimeMillis();
        List<PlanVo> planVoList = planService.selectPlanVoList2();
        //当前时间
//        long millisecond = System.currentTimeMillis();
//        String time_now = DateString.millisecondToStringLong(millisecond);

        for(PlanVo o: planVoList) {
            //当前时间
            long millisecond = System.currentTimeMillis();
            String time_now = DateString.millisecondToStringLong(millisecond);
            //已经生产完毕的计划不需要计算
//            if(o.getProduction_start_time() != null && o.getProduction_end_time() !=null && Time.TimeCompare2(o.getProduction_end_time(),time_now) < 0){
//                if(o.getProduction_status() == 2){
//                    o.setProduction_status(3);
//                    planService.updatePlanVo2(o);
//                    continue;
//                }
//                else {
//                    continue;
//                }
//            }
            //确保上模之后才需要计算
            if (o.getProduction_start_time() != null && Time.TimeCompare2(o.getProduction_start_time(),time_now) < 0) {
                //通过条件表明生产状态为生产中：2
                o.setProduction_status(2);
                //获取设备id
                String device_id = o.getDevice_id();
                Device_to_agreementVo device_to_agreementVo = deviceToAgreementService.selectDevice_to_agreementVoByDevice_id(device_id);
                //获取设备关联IoT设备ip
                String ip = device_to_agreementVo.getIp();
                //获取设备表名
                String table = "equipment_" + ip.replace('.', '_');
                o.setTable(table);
                //获取时间段内的合模次数
                String time1 = o.getProduction_start_time();
                String time2 = "";
                //有下模时间
                if(o.getProduction_end_time() != null){
                    //判断是否到下模时间，到了则以下模时间为准，未到则以当前时间为准
                    time2 = o.getProduction_end_time();
                }else{
                    //没有下模时间，直接以当前时间计算
                    time2 = time_now;
                }
                //
                int mold_number =planService.getQuantityByTime(table,time1,time2);
                int quantity = mold_number * o.getProduce_number();
                o.setActual_production_quantity(quantity);
                //获取大周期
                int cycle3 =planService.getCycle3ByTime(table,time1,time2);
                o.setActual_cycle(cycle3);

            }else{
                if(o.getProduction_status() == 1){
                    continue;
                }
                o.setProduction_status(1);
            }
//            System.out.println(o.toString());
            //更新方法//
            planService.updatePlanVo2(o);
        }
        //for结束
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));

    }


}

package com.ruoyi.web.service;

import com.ruoyi.web.domain.vo.Device_to_agreementVo;
import com.ruoyi.web.domain.vo.PlanVo;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/2 15:29
 * @Code : bug and work
 * @Description :计划生产服务类
 */
public interface PlanService {
    /**查询计划生产列表
     *
     * @param planVo 计划生产信息
     * @return
     */
    public List<PlanVo> selectPlanVoList(PlanVo planVo);

    public List<PlanVo> selectPlanVoList2();
    /**查询生产状态为生产中的计划生产列表
     *
     * @param
     * @return
     */
    public List<PlanVo> selectPlanVoList3();

    /**查询计划生产列表详细
     *
     * @param product_id 产品id device_id 设备id
     * @return 计划生产对象信息
     */
    public PlanVo selectPlanVoById(String product_id,String device_id,String cpo);

    /**
     * 校验计划生产编号
     *
     * @param planVo 计划生产信息
     * @return 结果
     */
    public boolean checkPlanIdUnique(PlanVo planVo);
    /**
     * 修改保存计划生产信息
     *
     * @param planVo 计划生产信息
     * @return 结果
     */
    public int updatePlanVo(PlanVo planVo);
    /**
     * 新增保存计划生产信息
     *
     * @param planVo 计划生产信息
     * @return 结果
     */
    public int insertPlanVo(PlanVo planVo);
    /**
     * 批量删除协议信息
     *
     * @param product_id 产品id device_id 设备id
     * @return 结果
     */
    public int deletePlanVoById(String[] product_id, String[] device_id, String[] cpo);
    /**
     * 获取合模次数
     *
     * @param table 表名 time1 合模开始时间 time2 下模时间或当前时间
     * @return 结果
     */
    public int getQuantityByTime(String table,String time1,String time2);

    /**
     * 获取运行周期
     *
     * @param table 表名 time1 合模开始时间 time2 下模时间或当前时间
     * @return 结果
     */
    public int getCycle3ByTime(String table,String time1,String time2);
    /**
     * 实时更新计划生产信息
     *
     * @param planVo 计划生产信息
     * @return 结果
     */
    public int updatePlanVo2(PlanVo planVo);

}

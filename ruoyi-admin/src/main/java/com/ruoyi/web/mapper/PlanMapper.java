package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.vo.Device_to_agreementVo;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.service.PlanService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/2 15:32
 * @Code : bug and work
 * @Description :
 */
public interface PlanMapper {
    /**
     * 查询计划生产列表
     *
     * @param planVo 计划生产信息
     * @return 计划生产集合
     */
    public List<PlanVo> selectPlanVoList(PlanVo planVo);

    public List<PlanVo> selectPlanVoList2();
    /**
     * 通过产品编号和设备编号查询计划生产信息
     *
     * @param device_id 设备编号 product_id 产品编号
     * @return 计划生产对象信息
     */
    public PlanVo selectPlanVoById(@Param("product_id") String product_id,@Param("device_id") String device_id,@Param("cpo") String cpo);
    /**
     * 校验计划生产编号
     *
     * @param device_id 设备编号 product_id 产品编号
     * @return 结果
     */
    public PlanVo checkPlanIdUnique(@Param("product_id") String product_id,@Param("device_id") String device_id,@Param("cpo") String cpo);

    /**
     * 修改计划生产信息
     *
     * @param planVo 计划生产信息
     * @return 结果
     */
    public int updatePlanVo(PlanVo planVo);
    /**
     * 新增计划生产信息
     *
     * @param planVo 计划生产信息
     * @return 结果
     */
    public int insertPlanVo(PlanVo planVo);
    /**
     * 批量删除协议信息
     *
     * @param device_id 设备编号 product_id 产品编号
     * @return 结果
     */
    public int PlanVoById(@Param("product_id") String[] product_id,@Param("device_id") String[] device_id,@Param("cpo") String[] cpo);
    /**
     * 获取合模次数
     *
     * @param table 表名 time1 合模开始时间 time2 下模时间或当前时间
     * @return 结果
     */
    public int getQuantityByTime(@Param("table") String table,@Param("time1")String time1,@Param("time2")String time2);
    /**
     * 获取运行大周期
     *
     * @param table 表名 time1 合模开始时间 time2 下模时间或当前时间
     * @return 结果
     */
    public int getCycle3ByTime(@Param("table") String table,@Param("time1")String time1,@Param("time2")String time2);
    /**
     * 实时更新计划生产信息
     *
     * @param planVo 计划生产信息
     * @return 结果
     */
    public int updatePlanVo2(PlanVo planVo);
}

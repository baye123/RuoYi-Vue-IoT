package com.ruoyi.web.service;

import com.ruoyi.web.domain.Produce;
import com.ruoyi.web.domain.vo.PlanVo;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/12 10:45
 * @Code : bug and work
 * @Description : 实时生产服务层
 */
public interface ProduceService {
    /**查询实时生产列表
     *
     * @param produce 实时生产信息
     * @return
     */
    public List<Produce> selectProduceList(Produce produce);

    public List<Produce> selectProduceList2();

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
    public Integer getCycle3ByTime(String table,String time1,String time2);
}

package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Produce;
import com.ruoyi.web.domain.vo.PlanVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/12 10:48
 * @Code : bug and work
 * @Description :
 */
public interface ProduceMapper {
    /**
     * 查询实时生产列表
     *
     * @param produce 实时生产信息
     * @return 实时生产集合
     */
    public List<Produce> selectProduceList(Produce produce);

    public List<Produce> selectProduceList2();

    /**
     * 获取合模次数
     *
     * @param table 表名 time1 合模开始时间 time2 下模时间或当前时间
     * @return 结果
     */
    public int getQuantityByTime(@Param("table") String table, @Param("time1")String time1, @Param("time2")String time2);
    /**
     * 获取运行大周期
     *
     * @param table 表名 time1 合模开始时间 time2 下模时间或当前时间
     * @return 结果
     */
    public Integer getCycle3ByTime(@Param("table") String table,@Param("time1")String time1,@Param("time2")String time2);
}

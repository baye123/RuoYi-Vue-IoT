package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Shpmachud;
import com.ruoyi.web.domain.vo.PlanVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/9 11:23
 * @Code : bug and work
 * @Description :
 */
public interface ShpmachudMapper {
    /**
     * 查询机台流水列表
     *
     * @param shpmachud 机台流水信息
     * @return 机台流水集合
     */
    public List<Shpmachud> selectShpmachudList(Shpmachud shpmachud);

    /**
     * 类别为“生产”以外的机台流水列表
     * @return
     */
    public List<Shpmachud> selectShpmachudList2();
    /**
     * 通过产品编号和设备编号查询已经进入生产的机台流水列表
     *
     * @param device_id 设备编号 product_id 产品编号
     * @return 机台流水对象信息
     */
    public Shpmachud selectShpmachudById(@Param("product_id") String product_id, @Param("device_id") String device_id, @Param("cpo") String cpo);

    /**
     * 实时更新机台流水信息
     *
     * @param shpmachud 计划生产信息
     * @return 结果
     */
    public int updateShpmachud2(Shpmachud shpmachud);

}

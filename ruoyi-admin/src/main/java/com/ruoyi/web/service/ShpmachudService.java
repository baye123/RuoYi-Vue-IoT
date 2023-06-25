package com.ruoyi.web.service;

import com.ruoyi.web.domain.Shpmachud;
import com.ruoyi.web.domain.vo.PlanVo;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/9 11:18
 * @Code : bug and work
 * @Description : 机台流水单服务类
 */
public interface ShpmachudService {
    /**查询机台流水列表
     *
     * @param shpmachud 机台流水信息
     * @return
     */
    public List<Shpmachud> selectShpmachudList(Shpmachud shpmachud);

    public List<Shpmachud> selectShpmachudList2();
    /**查询机台流水列表详细（正在生产）
     *
     * @param product_id 产品id device_id 设备id
     * @return 机台流水对象信息
     */
    public List<Shpmachud> selectShpmachudById(String product_id, String device_id, String cpo);
    /**
     * 实时更新机台流水生产信息
     *
     * @param shpmachud 机台流水生产信息
     * @return 结果
     */
    public int updateShpmachud2(Shpmachud shpmachud);
    /**查询同设备与开合模时间最相近的流水单，用于合模历史
     *
     * @param device_id 设备编号 time 合模时间
     * @return 流水单对象信息
     */
    public Shpmachud selectShpmachudByDevice_idAndTime(String device_id, String dotime);

}

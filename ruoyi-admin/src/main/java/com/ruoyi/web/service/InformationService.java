package com.ruoyi.web.service;

import com.ruoyi.system.domain.SysPost;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.SocketMsg;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/10 16:23
 * @Code : bug and work
 * @Description : 设备信息服务类
 */
public interface InformationService {
    /**
     *
     * @param device
     * @return
     */
    public List<Device> selectDeviceList(Device device);
    /**
     * 校验设备编码
     *
     * @param device 设备信息
     * @return 结果
     */
    public boolean checkInformationIdUnique(Device device);
    /**
     * 通过设备编号查询设备信息
     *
     * @param device_id 设备编号
     * @return 设备对象信息
     */
    public Device selectDeviceByDevice_id(String device_id);

    /**
     * 新增保存设备信息
     *
     * @param device 设备信息
     * @return 结果
     */
    public int insertDevice(Device device);
    /**
     * 修改保存设备信息
     *
     * @param device 设备信息
     * @return 结果
     */
    public int updateDevice(Device device);
    /**
     * 批量删除设备信息
     *
     * @param device_ids 需要删除的岗位编号
     * @return 结果
     */
    public int deleteDeviceByDevice_ids(String[] device_ids);
}

package com.ruoyi.web.mapper;

import com.ruoyi.system.domain.SysPost;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.EquipmentConfig;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/10 16:28
 * @Code : bug and work
 * @Description :
 */
public interface InformationMapper {
    /**
     * 查询设备信息列表
     *
     * @param device 设备信息
     * @return 设备集合
     */
    public List<Device> selectDeviceList(Device device);
    /**
     * 查询设备编号列表
     *
     * @param
     * @return 设备集合
     */
    public List<Device> selectDevice_idList();
    /**
     * 校验设备编码
     *
     * @param device_id 设备编码
     * @return 结果
     */
    public Device checkInformationIdUnique(String device_id);
    /**
     * 通过设备编号查询设备信息
     *
     * @param device_id 设备编号
     * @return 设备对象信息
     */
    public Device selectDeviceByDevice_id(String device_id);
    /**
     * 新增设备信息
     *
     * @param device 岗位信息
     * @return 结果
     */
    public int insertDevice(Device device);
    /**
     * 修改设备信息
     *
     * @param device 岗位信息
     * @return 结果
     */
    public int updateDevice(Device device);
    /**
     * 批量删除设备信息
     *
     * @param device_ids 需要删除的岗位编码
     * @return 结果
     */
    public int DeviceByDevice_ids(String[] device_ids);

    public String getIpByDevice_id(String device_id);
}

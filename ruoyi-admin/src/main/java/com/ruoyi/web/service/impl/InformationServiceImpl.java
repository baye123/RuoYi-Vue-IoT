package com.ruoyi.web.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.EquipmentConfig;
import com.ruoyi.web.mapper.InformationMapper;
import com.ruoyi.web.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/10 16:24
 * @Code : bug and work
 * @Description :
 */
@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    InformationMapper informationMapper;

    @Override
    public List<Device> selectDeviceList(Device device){
        return informationMapper.selectDeviceList(device);
    }
    @Override
    public List<Device> selectDevice_idList(){
        return informationMapper.selectDevice_idList();
    }
    /**
     * 通过设备编号查询设备信息
     *
     * @param device_id 设备编号
     * @return 设备对象信息
     */
    @Override
    public Device selectDeviceByDevice_id(String device_id)
    {
        return informationMapper.selectDeviceByDevice_id(device_id);
    }
    /**
     * 校验设备编码是否唯一
     *
     * @param device 设备信息
     * @return 结果
     */
    @Override
    public boolean checkInformationIdUnique(Device device)
    {
        Long Id = StringUtils.isNull(device.getId()) ? -1L : device.getId();
        Device info = informationMapper.checkInformationIdUnique(device.getDevice_id());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != Id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
    /**
     * 新增保存设备信息
     *
     * @param device 设备信息
     * @return 结果
     */
    @Override
    public int insertDevice(Device device)
    {
        return informationMapper.insertDevice(device);
    }
    /**
     * 修改保存设备信息
     *
     * @param device 设备信息
     * @return 结果
     */
    @Override
    public int updateDevice(Device device)
    {
        return informationMapper.updateDevice(device);
    }
    /**
     * 批量删除岗位信息
     *
     * @param device_ids 需要删除的岗位编码
     * @return 结果
     */
    @Override
    public int deleteDeviceByDevice_ids(String[] device_ids)
    {
        return informationMapper.DeviceByDevice_ids(device_ids);
    }
    @Override
    public String getIpByDevice_id(String device_id){
        return informationMapper.getIpByDevice_id(device_id);
    }
}

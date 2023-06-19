package com.ruoyi.web.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.vo.Device_to_agreementVo;
import com.ruoyi.web.mapper.DeviceToAgreementMapper;
import com.ruoyi.web.mapper.EquipmentConfigMapper;
import com.ruoyi.web.service.DeviceToAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/19 10:39
 * @Code : bug and work
 * @Description :
 */
@Service
public class DeviceToAgreementServiceImpl implements DeviceToAgreementService {

    @Autowired
    DeviceToAgreementMapper deviceToAgreementMapper;

    /**查询策略详情列表
     *
     * @param device_to_agreementVo 策略详情信息
     * @return
     */
    @Override
    public List<Device_to_agreementVo> selectDevice_to_agreementVoList(Device_to_agreementVo device_to_agreementVo){
        return deviceToAgreementMapper.selectDevice_to_agreementVoList(device_to_agreementVo);
    }
    /**
     * 校验协议编号
     *
     * @param device_to_agreementVo 策略详情信息
     * @return 结果
     */
    @Override
    public boolean checkAgreementIdUnique(Device_to_agreementVo device_to_agreementVo){
        Long Id = StringUtils.isNull(device_to_agreementVo.getId()) ? -1L : device_to_agreementVo.getId();
        Device_to_agreementVo info =deviceToAgreementMapper.checkAgreementIdUnique(device_to_agreementVo.getAgreement_id());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != Id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;

    }
    /**
     * 通过协议编号查询协议信息
     *
     * @param agreement_id 设备编号
     * @return 策略详情对象信息
     */
    @Override
    public Device_to_agreementVo selectDevice_to_agreementVoByAgreement_id(String agreement_id){
        return deviceToAgreementMapper.selectDevice_to_agreementVoByAgreement_id(agreement_id);

    }

    /**
     * 新增保存协议信息
     *
     * @param device_to_agreementVo 策略详情信息
     * @return 结果
     */
    @Override
    public int insertDevice_to_agreementVo(Device_to_agreementVo device_to_agreementVo){
        return deviceToAgreementMapper.insertDevice_to_agreementVo(device_to_agreementVo);

    }
    /**
     * 修改保存协议信息
     *
     * @param device_to_agreementVo 策略详情信息
     * @return 结果
     */
    @Override
    public int updateDevice_to_agreementVo(Device_to_agreementVo device_to_agreementVo){
        return deviceToAgreementMapper.updateDevice_to_agreementVo(device_to_agreementVo);

    }
    /**
     * 批量删除协议信息
     *
     * @param agreement_ids 需要删除的协议编号
     * @return 结果
     */
    @Override
    public int deleteDevice_to_agreementVoByAgreement_ids(String[] agreement_ids){
        return deviceToAgreementMapper.Device_to_agreementVoByAgreement_ids(agreement_ids);
    }

    @Override
    public Device_to_agreementVo selectDevice_to_agreementVoByDevice_id(String device_id){
        return deviceToAgreementMapper.selectDevice_to_agreementVoByDevice_id(device_id);
    }

}

package com.ruoyi.web.service;

import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.vo.Device_to_agreementVo;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/18 17:10
 * @Code : bug and work
 * @Description :
 */
public interface DeviceToAgreementService {
    /**查询策略详情列表
     *
     * @param device_to_agreementVo 策略详情信息
     * @return
     */
    public List<Device_to_agreementVo> selectDevice_to_agreementVoList(Device_to_agreementVo device_to_agreementVo);
    /**
     * 校验协议编号
     *
     * @param device_to_agreementVo 策略详情信息
     * @return 结果
     */
    public boolean checkAgreementIdUnique(Device_to_agreementVo device_to_agreementVo);
    /**
     * 通过协议编号查询协议信息
     *
     * @param agreement_id 设备编号
     * @return 策略详情对象信息
     */
    public Device_to_agreementVo selectDevice_to_agreementVoByAgreement_id(String agreement_id);

    /**
     * 新增保存协议信息
     *
     * @param device_to_agreementVo 策略详情信息
     * @return 结果
     */
    public int insertDevice_to_agreementVo(Device_to_agreementVo device_to_agreementVo);
    /**
     * 修改保存协议信息
     *
     * @param device_to_agreementVo 策略详情信息
     * @return 结果
     */
    public int updateDevice_to_agreementVo(Device_to_agreementVo device_to_agreementVo);
    /**
     * 批量删除协议信息
     *
     * @param agreement_ids 需要删除的协议编号
     * @return 结果
     */
    public int deleteDevice_to_agreementVoByAgreement_ids(String[] agreement_ids);
}

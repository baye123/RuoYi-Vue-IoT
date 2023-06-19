package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.vo.Device_to_agreementVo;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/19 11:08
 * @Code : bug and work
 * @Description :
 */
public interface DeviceToAgreementMapper {
    /**
     * 查询协议信息列表
     *
     * @param device_to_agreementVo 策略详情信息
     * @return 协议集合
     */
    public List<Device_to_agreementVo> selectDevice_to_agreementVoList(Device_to_agreementVo device_to_agreementVo);
    /**
     * 校验协议编号
     *
     * @param agreement_id 协议编号
     * @return 结果
     */
    public Device_to_agreementVo checkAgreementIdUnique(String agreement_id);
    /**
     * 通过协议编号查询协议信息
     *
     * @param agreement_id 协议编号
     * @return 设备协议对象信息
     */
    public Device_to_agreementVo selectDevice_to_agreementVoByAgreement_id(String agreement_id);
    /**
     * 新增协议信息
     *
     * @param device_to_agreementVo 协议信息
     * @return 结果
     */
    public int insertDevice_to_agreementVo(Device_to_agreementVo device_to_agreementVo);
    /**
     * 修改协议信息
     *
     * @param device_to_agreementVo 协议信息
     * @return 结果
     */
    public int updateDevice_to_agreementVo(Device_to_agreementVo device_to_agreementVo);
    /**
     * 批量删除协议信息
     *
     * @param agreement_ids 需要删除的协议编号
     * @return 结果
     */
    public int Device_to_agreementVoByAgreement_ids(String[] agreement_ids);

    /**
     * 通过设备编号查询协议信息
     *
     * @param device_id 设备编号
     * @return 设备协议对象信息
     */
    public Device_to_agreementVo selectDevice_to_agreementVoByDevice_id(String device_id);
}

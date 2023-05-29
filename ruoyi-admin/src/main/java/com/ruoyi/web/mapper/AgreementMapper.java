package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.Device;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/12 15:08
 * @Code : bug and work
 * @Description :
 */
public interface AgreementMapper {
    /**
     * 查询协议信息列表
     *
     * @param agreement 协议信息
     * @return 协议集合
     */
    public List<Agreement> selectAgreementList(Agreement agreement);
    /**
     * 校验协议编号
     *
     * @param agreement_id 协议编号
     * @return 结果
     */
    public Agreement checkAgreementIdUnique(String agreement_id);
    /**
     * 通过协议编号查询协议信息
     *
     * @param agreement_id 设备编号
     * @return 设备对象信息
     */
    public Agreement selectAgreementByAgreement_id(String agreement_id);
    /**
     * 新增协议信息
     *
     * @param agreement 协议信息
     * @return 结果
     */
    public int insertAgreement(Agreement agreement);
    /**
     * 修改协议信息
     *
     * @param agreement 协议信息
     * @return 结果
     */
    public int updateAgreement(Agreement agreement);
    /**
     * 批量删除协议信息
     *
     * @param agreement_ids 需要删除的协议编号
     * @return 结果
     */
    public int AgreementByAgreement_ids(String[] agreement_ids);
}

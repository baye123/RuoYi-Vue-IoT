package com.ruoyi.web.service;

import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.Tokyo_33;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/12 15:05
 * @Code : bug and work
 * @Description : 数采协议服务层
 */
public interface AgreementService {
    /**查询协议列表
     *
     * @param agreement 协议信息
     * @return
     */
    public List<Agreement> selectAgreementList(Agreement agreement);
    /**
     * 校验协议编号
     *
     * @param agreement 协议信息
     * @return 结果
     */
    public boolean checkAgreementIdUnique(Agreement agreement);
    /**
     * 通过协议编号查询协议信息
     *
     * @param agreement_id 设备编号
     * @return 协议对象信息
     */
    public Agreement selectAgreementByAgreement_id(String agreement_id);

    /**
     * 新增保存协议信息
     *
     * @param agreement 协议信息
     * @return 结果
     */
    public int insertAgreement(Agreement agreement);
    /**
     * 修改保存协议信息
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
    public int deleteAgreementByAgreement_ids(String[] agreement_ids);
    /**
     * 查询协议为东洋TCP的协议列表
     * @param
     * @return
     */
    public List<Agreement> selectTokyo_AgreementList();
}

package com.ruoyi.web.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.mapper.AgreementMapper;
import com.ruoyi.web.mapper.InformationMapper;
import com.ruoyi.web.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/12 15:06
 * @Code : bug and work
 * @Description :
 */
@Service
public class AgreementServiceImpl implements AgreementService {
    @Autowired
    AgreementMapper agreementMapper;

    @Override
    public List<Agreement> selectAgreementList(Agreement agreement){
        return agreementMapper.selectAgreementList(agreement);
    }

    /**
     * 通过协议编号查询协议信息
     *
     * @param agreement_id 设备编号
     * @return 设备对象信息
     */
    @Override
    public Agreement selectAgreementByAgreement_id(String agreement_id)
    {
        return agreementMapper.selectAgreementByAgreement_id(agreement_id);
    }
    /**
     * 校验协议编码是否唯一
     *
     * @param agreement 协议信息
     * @return 结果
     */
    @Override
    public boolean checkAgreementIdUnique(Agreement agreement)
    {
        Long Id = StringUtils.isNull(agreement.getId()) ? -1L : agreement.getId();
        Agreement info = agreementMapper.checkAgreementIdUnique(agreement.getAgreement_id());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != Id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
    /**
     * 新增保存协议信息
     *
     * @param agreement 协议信息
     * @return 结果
     */
    @Override
    public int insertAgreement(Agreement agreement)
    {
        return agreementMapper.insertAgreement(agreement);
    }
    /**
     * 修改保存协议信息
     *
     * @param agreement 协议信息
     * @return 结果
     */
    @Override
    public int updateAgreement(Agreement agreement)
    {
        return agreementMapper.updateAgreement(agreement);
    }
    /**
     * 批量删除岗位信息
     *
     * @param agreement_ids 需要删除的岗位编码
     * @return 结果
     */
    @Override
    public int deleteAgreementByAgreement_ids(String[] agreement_ids)
    {
        return agreementMapper.AgreementByAgreement_ids(agreement_ids);
    }

    @Override
    public List<Agreement> selectTokyo_AgreementList(){
        return agreementMapper.selectTokyo_AgreementList();
    }

}

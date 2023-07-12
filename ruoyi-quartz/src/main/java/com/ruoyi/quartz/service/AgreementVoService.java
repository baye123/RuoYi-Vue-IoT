package com.ruoyi.quartz.service;

import com.ruoyi.quartz.domain.AgreementVo;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/24 14:31
 * @Code : bug and work
 * @Description : 协议服务类
 */
public interface AgreementVoService {
    /**查询协议列表(仅查询IoT协议）
     *
     * @param
     * @return
     */
    public List<AgreementVo> getAgreementVoList();
}

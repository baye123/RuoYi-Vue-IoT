package com.ruoyi.quartz.service.impl;

import com.ruoyi.quartz.domain.AgreementVo;
import com.ruoyi.quartz.mapper.AgreementVoMapper;
import com.ruoyi.quartz.service.AgreementVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/24 14:34
 * @Code : bug and work
 * @Description :
 */
@Service
public class AgreementVoServiceImpl implements AgreementVoService {
    @Autowired
    AgreementVoMapper agreementVoMapper;


    @Override
    public List<AgreementVo> getAgreementVoList(){
        return agreementVoMapper.getAgreementVoList();

    }
}

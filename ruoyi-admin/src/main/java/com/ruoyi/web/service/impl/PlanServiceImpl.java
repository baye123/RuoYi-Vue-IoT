package com.ruoyi.web.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.util.DateString;
import com.ruoyi.web.domain.vo.Device_to_agreementVo;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.mapper.PlanMapper;
import com.ruoyi.web.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/2 15:31
 * @Code : bug and work
 * @Description :
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    PlanMapper planMapper;

    @Override
    public List<PlanVo> selectPlanVoList(PlanVo planVo){

        return planMapper.selectPlanVoList(planVo);

    }
    @Override
    public List<PlanVo> selectPlanVoList2(){
        return planMapper.selectPlanVoList2();
    }
    @Override
    public List<PlanVo> selectPlanVoList3(){
        return planMapper.selectPlanVoList3();
    }

    @Override
    public PlanVo selectPlanVoById(String product_id,String device_id,String cpo){
        return planMapper.selectPlanVoById(product_id,device_id,cpo);
    }

    @Override
    public boolean checkPlanIdUnique(PlanVo planVo){
        Long Id = StringUtils.isNull(planVo.getId()) ? -1L : planVo.getId();
        PlanVo info = planMapper.checkPlanIdUnique(planVo.getProduct_id(),planVo.getDevice_id(),planVo.getCpo());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != Id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;

    }

    @Override
    public int updatePlanVo(PlanVo planVo){
        return planMapper.updatePlanVo(planVo);
    }
    @Override
    public int insertPlanVo(PlanVo planVo){
        return planMapper.insertPlanVo(planVo);
    }
    @Override
    public int deletePlanVoById(String[] product_id, String[] device_id, String[] cpo){
        return planMapper.PlanVoById(product_id, device_id, cpo);
    }

    @Override
    public int getQuantityByTime(String table,String time1,String time2){
        return planMapper.getQuantityByTime(table,time1,time2);
    }
    @Override
    public int getCycle3ByTime(String table,String time1,String time2){
        return planMapper.getCycle3ByTime(table,time1,time2);
    }
    @Override
    public int updatePlanVo2(PlanVo planVo){
        return planMapper.updatePlanVo2(planVo);
    }
}


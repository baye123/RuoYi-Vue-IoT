package com.ruoyi.web.service.impl;

import com.ruoyi.web.domain.Produce;
import com.ruoyi.web.domain.Shpmachud;
import com.ruoyi.web.mapper.PlanMapper;
import com.ruoyi.web.mapper.ProduceMapper;
import com.ruoyi.web.service.ProduceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/12 10:46
 * @Code : bug and work
 * @Description :
 */
@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    ProduceMapper produceMapper;

    @Override
    public List<Produce> selectProduceList(Produce produce){
        return produceMapper.selectProduceList(produce);

    }

    @Override
    public List<Produce> selectProduceList2(){
        return produceMapper.selectProduceList2();
    }
    @Override
    public int getQuantityByTime(String table,String time1,String time2){
        return produceMapper.getQuantityByTime(table,time1,time2);
    }
    @Override
    public Integer getCycle3ByTime(String table,String time1,String time2){
        return produceMapper.getCycle3ByTime(table,time1,time2);
    }

}

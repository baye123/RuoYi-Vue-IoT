package com.ruoyi.web.service.impl;

import com.ruoyi.web.domain.Shpmachud;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.mapper.ShpmachudMapper;
import com.ruoyi.web.service.ShpmachudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/9 11:22
 * @Code : bug and work
 * @Description :
 */
@Service
public class ShpmachudServiceImpl implements ShpmachudService {
    @Autowired
    ShpmachudMapper shpmachudMapper;


    @Override
    public List<Shpmachud> selectShpmachudList(Shpmachud shpmachud){
        return shpmachudMapper.selectShpmachudList(shpmachud);
    }
    @Override
    public List<Shpmachud> selectShpmachudList2(){
        return shpmachudMapper.selectShpmachudList2();
    }

    @Override
    public Shpmachud selectShpmachudById(String product_id, String device_id, String cpo){
        return shpmachudMapper.selectShpmachudById(product_id,device_id,cpo);
    }
    @Override
    public int updateShpmachud2(Shpmachud shpmachud){
        return shpmachudMapper.updateShpmachud2(shpmachud);
    }

}

package com.ruoyi.web.service.impl;

import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.web.domain.Tokyo_33;
import com.ruoyi.web.domain.Tokyo_46;
import com.ruoyi.web.domain.ToyoMessage;
import com.ruoyi.web.mapper.TokyoMapper;
import com.ruoyi.web.service.TokyoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/7/4 11:37
 * @Code : bug and work
 * @Description :
 */
@Service
public class TokyoServiceImpl implements TokyoService {
    @Autowired
    TokyoMapper tokyoMapper;

    @Override
    public int saveTokyo(Tokyo_33 tokyo_33){
        if (tokyoMapper.existTable(tokyo_33.getTable()) == 0) {
            return tokyoMapper.createNewTable(tokyo_33.getTable());

        }
        return tokyoMapper.saveTokyo(tokyo_33);
    }
    @Override
    public int saveTokyo46(Tokyo_46 tokyo_46){
        if (tokyoMapper.existTable(tokyo_46.getTable()) == 0) {
            return tokyoMapper.createNewTable46(tokyo_46.getTable());

        }
        return tokyoMapper.saveTokyo46(tokyo_46);
    }

    @Override
    public List<Tokyo_33> selectTokyo_33List(Tokyo_33 tokyo_33){
        String IP = tokyoMapper.getIpByDevice_id(tokyo_33.getDevice_id());
        String table = "tokyo_" + IP.replace('.','_');
        tokyo_33.setTable(table);

        PageUtils.startPage();
        return tokyoMapper.selectTokyo_33List(tokyo_33);
    }
    @Override
    public List<Tokyo_33> selectTokyo_33List2(Tokyo_33 tokyo_33){
        String IP = tokyoMapper.getIpByDevice_id(tokyo_33.getDevice_id());
        String table = "tokyo_" + IP.replace('.','_');
        tokyo_33.setTable(table);

//        PageUtils.startPage();
        return tokyoMapper.selectTokyo_33List(tokyo_33);
    }

    @Override
    public List<Tokyo_46> selectTokyo_46List(Tokyo_46 tokyo_46){
        String IP = tokyoMapper.getIpByDevice_id(tokyo_46.getDevice_id());
        String table = "tokyo46_" + IP.replace('.','_');
        tokyo_46.setTable(table);

        PageUtils.startPage();
        return tokyoMapper.selectTokyo_46List(tokyo_46);
    }

    @Override
    public List<Tokyo_46> selectTokyo_46List2(Tokyo_46 tokyo_46){
        String IP = tokyoMapper.getIpByDevice_id(tokyo_46.getDevice_id());
        String table = "tokyo46_" + IP.replace('.','_');
        tokyo_46.setTable(table);

//        PageUtils.startPage();
        return tokyoMapper.selectTokyo_46List(tokyo_46);
    }

}

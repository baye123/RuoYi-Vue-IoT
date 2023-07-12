package com.ruoyi.web.service;

import com.ruoyi.web.domain.Tokyo_33;
import com.ruoyi.web.domain.Tokyo_46;
import com.ruoyi.web.domain.ToyoMessage;
import com.ruoyi.web.mapper.TokyoMapper;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/7/4 11:20
 * @Code : bug and work
 * @Description : 可配置东洋类服务层
 */
public interface TokyoService {
    /**
     * 保存一条东洋数据到相对应的表内
     * @param tokyo_33
     * @return
     */
    public int saveTokyo(Tokyo_33 tokyo_33);

    public int saveTokyo46(Tokyo_46 tokyo_46);

    public List<Tokyo_33> selectTokyo_33List(Tokyo_33 tokyo_33);

    public List<Tokyo_46> selectTokyo_46List(Tokyo_46 tokyo_46);

    public List<Tokyo_33> selectTokyo_33List2(Tokyo_33 tokyo_33);

    public List<Tokyo_46> selectTokyo_46List2(Tokyo_46 tokyo_46);



}

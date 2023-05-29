package com.ruoyi.web.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.EquipmentConfig;
import com.ruoyi.web.mapper.EquipmentConfigMapper;
import com.ruoyi.web.service.EquipmentConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/4/28 14:11
 * @Code : bug and work
 * @Description :
 */
@Service
public class EquipmentConfigServiceImpl implements EquipmentConfigService {

    @Autowired
    EquipmentConfigMapper equipmentConfigMapper;



    @Override
    public List<EquipmentConfig> selectEquipmentConfigList(EquipmentConfig equipmentConfig){
        return equipmentConfigMapper.selectEquipmentList(equipmentConfig);
    }

}

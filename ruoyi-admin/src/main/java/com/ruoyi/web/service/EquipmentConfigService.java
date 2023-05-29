package com.ruoyi.web.service;

import com.ruoyi.web.domain.EquipmentConfig;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/4/28 14:09
 * @Code : bug and work
 * @Description :设备配置服务类
 */
public interface EquipmentConfigService {
    /**
     *
     * @param equipmentConfig
     * @return
     */
    public List<EquipmentConfig> selectEquipmentConfigList(EquipmentConfig equipmentConfig);
}

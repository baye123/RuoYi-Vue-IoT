package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.EquipmentConfig;
import com.ruoyi.web.domain.SocketMsg;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/4/28 14:13
 * @Code : bug and work
 * @Description : 设备配置
 */
public interface EquipmentConfigMapper {
    /**
     * 查询设备配置列表
     *
     * @param equipmentConfig 设备配置信息
     * @return 配置集合
     */
    public List<EquipmentConfig> selectEquipmentList(EquipmentConfig equipmentConfig);
}

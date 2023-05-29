package com.ruoyi.web.controller.service;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.domain.EquipmentConfig;
import com.ruoyi.web.service.EquipmentConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/4/28 14:03
 * @Code : bug and work
 * @Description : 设备配置控制类
 */
@RestController
@RequestMapping("/server/config")
public class EquipmentConfigController extends BaseController {

    @Autowired
    private EquipmentConfigService equipmentConfigService;
    /**
     * 获取设备配置列表
     */
    @PreAuthorize("@ss.hasPermi('server:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentConfig equipmentConfig)
    {
        startPage();
        List<EquipmentConfig> equipmentConfigList = equipmentConfigService.selectEquipmentConfigList(equipmentConfig);
        return getDataTable(equipmentConfigList);
    }
}

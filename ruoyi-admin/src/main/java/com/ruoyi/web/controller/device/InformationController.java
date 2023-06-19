package com.ruoyi.web.controller.device;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictType;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.SocketMsg;
import com.ruoyi.web.service.InformationService;
import com.ruoyi.web.service.SocketMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/10 14:59
 * @Code : bug and work
 * @Description : 设备控制类
 */
@RestController
@RequestMapping("/device/information")
public class InformationController extends BaseController {
    @Autowired
    private InformationService informationService;

    /**
     * 获取设备列表
     */
    @PreAuthorize("@ss.hasPermi('device:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(Device device)
    {
        startPage();
        List<Device> deviceList = informationService.selectDeviceList(device);
        return getDataTable(deviceList);
    }
    /**
     * 根据设备编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:information:query')")
    @GetMapping(value = "/{device_id}")
    public AjaxResult getInfo(@PathVariable String device_id)
    {
        return success(informationService.selectDeviceByDevice_id(device_id));
    }
    /**
     * 新增设备
     */
    @PreAuthorize("@ss.hasPermi('device:information:add')")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Device device)
    {
        device.setCreate_by(getUsername());
        if (!informationService.checkInformationIdUnique(device))
        {
            return error("新增设备'" + device.getDevice_id() + "'失败，设备编码已存在");
        }
        device.setCreateBy(getUsername());
        return toAjax(informationService.insertDevice(device));
    }
    /**
     * 修改设备
     */
    @PreAuthorize("@ss.hasPermi('device:information:edit')")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Device device)
    {
        if (!informationService.checkInformationIdUnique(device))
        {
            return error("修改岗位'" + device.getDevice_id() + "'失败，设备编码已存在");
        }
        device.setUpdate_by(getUsername());
        return toAjax(informationService.updateDevice(device));
    }
    /**
     * 删除设备
     */
    @PreAuthorize("@ss.hasPermi('device:information:remove')")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{device_ids}")
    public AjaxResult remove(@PathVariable String[] device_ids)
    {
        return toAjax(informationService.deleteDeviceByDevice_ids(device_ids));
    }
    /**
     * 获取设备编号列表
     */
    @GetMapping("/device_idlist")
    public AjaxResult optionselect()
    {
        List<Device> device_idList = informationService.selectDevice_idList();
        return success(device_idList);
    }

}

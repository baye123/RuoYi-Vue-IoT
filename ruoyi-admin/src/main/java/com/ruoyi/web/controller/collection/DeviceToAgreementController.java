package com.ruoyi.web.controller.collection;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.vo.Device_to_agreementVo;
import com.ruoyi.web.service.AgreementService;
import com.ruoyi.web.service.DeviceToAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/18 16:42
 * @Code : bug and work
 * @Description : 数采策略控制层
 */
@RestController
@RequestMapping("/collection/device_to_agreement")
public class DeviceToAgreementController extends BaseController {
    @Autowired
    private DeviceToAgreementService deviceToAgreementService;

    /**
     * 获取策略详情列表
     */
    @PreAuthorize("@ss.hasPermi('collection:device_to_agreement:list')")
    @GetMapping("/list")
    public TableDataInfo list(Device_to_agreementVo device_to_agreementVo)
    {
        startPage();
        List<Device_to_agreementVo> device_to_agreementVoList = deviceToAgreementService.selectDevice_to_agreementVoList(device_to_agreementVo);
        return getDataTable(device_to_agreementVoList);
    }
    /**
     * 根据协议编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('collection:device_to_agreement:query')")
    @GetMapping(value = "/{agreement_id}")
    public AjaxResult getInfo(@PathVariable String agreement_id)
    {
        return success(deviceToAgreementService.selectDevice_to_agreementVoByAgreement_id(agreement_id));
    }
    /**
     * 新增策略详情
     */
    @PreAuthorize("@ss.hasPermi('collection:device_to_agreement:add')")
    @Log(title = "数采策略管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Device_to_agreementVo device_to_agreementVo)
    {

        if (!deviceToAgreementService.checkAgreementIdUnique(device_to_agreementVo))
        {
            return error("新增协议'" + device_to_agreementVo.getAgreement_id() + "'失败，协议编号已存在");
        }

        return toAjax(deviceToAgreementService.insertDevice_to_agreementVo(device_to_agreementVo));
    }
    /**
     * 修改策略详情
     */
    @PreAuthorize("@ss.hasPermi('collection:device_to_agreement:edit')")
    @Log(title = "数采策略管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Device_to_agreementVo device_to_agreementVo)
    {
        if (!deviceToAgreementService.checkAgreementIdUnique(device_to_agreementVo))
        {
            return error("修改协议'" + device_to_agreementVo.getAgreement_id() + "'失败，协议编号已存在");
        }
        return toAjax(deviceToAgreementService.updateDevice_to_agreementVo(device_to_agreementVo));
    }
    /**
     * 删除数采策略
     */
    @PreAuthorize("@ss.hasPermi('collection:device_to_agreement:remove')")
    @Log(title = "数采策略管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{agreement_ids}")
    public AjaxResult remove(@PathVariable String[] agreement_ids)
    {
        return toAjax(deviceToAgreementService.deleteDevice_to_agreementVoByAgreement_ids(agreement_ids));
    }
    /**
     * 导出协议数据
     */
    @Log(title = "数采策略管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('collection:device_to_agreement:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Device_to_agreementVo device_to_agreementVo)
    {
        List<Device_to_agreementVo> device_to_agreementVoList = deviceToAgreementService.selectDevice_to_agreementVoList(device_to_agreementVo);
        ExcelUtil<Device_to_agreementVo> util = new ExcelUtil<Device_to_agreementVo>(Device_to_agreementVo.class);
        util.exportExcel(response, device_to_agreementVoList, "数采策略数据");
    }


}

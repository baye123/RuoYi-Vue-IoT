package com.ruoyi.web.controller.collection;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.Agreement;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.ToyoMessage;
import com.ruoyi.web.service.AgreementService;
import com.ruoyi.web.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/12 14:55
 * @Code : bug and work
 * @Description : 数采协议控制层
 */
@RestController
@RequestMapping("/collection/agreement")
public class AgreementController extends BaseController {
    @Autowired
    private AgreementService agreementService;

    /**
     * 获取协议列表
     */
    @PreAuthorize("@ss.hasPermi('collection:agreement:list')")
    @GetMapping("/list")
    public TableDataInfo list(Agreement agreement)
    {
        startPage();
        List<Agreement> agreementList = agreementService.selectAgreementList(agreement);
        return getDataTable(agreementList);
    }
    /**
     * 根据协议编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('collection:agreement:query')")
    @GetMapping(value = "/{agreement_id}")
    public AjaxResult getInfo(@PathVariable String agreement_id)
    {
        return success(agreementService.selectAgreementByAgreement_id(agreement_id));
    }
    /**
     * 新增协议
     */
    @PreAuthorize("@ss.hasPermi('collection:agreement:add')")
    @Log(title = "数采协议管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Agreement agreement)
    {
        agreement.setCreate_by(getUsername());
        if (!agreementService.checkAgreementIdUnique(agreement))
        {
            return error("新增协议'" + agreement.getAgreement_id() + "'失败，协议编号已存在");
        }
        agreement.setCreateBy(getUsername());
        return toAjax(agreementService.insertAgreement(agreement));
    }
    /**
     * 修改设备
     */
    @PreAuthorize("@ss.hasPermi('collection:agreement:edit')")
    @Log(title = "数采协议管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Agreement agreement)
    {
        if (!agreementService.checkAgreementIdUnique(agreement))
        {
            return error("修改协议'" + agreement.getAgreement_id() + "'失败，协议编号已存在");
        }
        agreement.setUpdate_by(getUsername());
        return toAjax(agreementService.updateAgreement(agreement));
    }
    /**
     * 删除设备
     */
    @PreAuthorize("@ss.hasPermi('collection:agreement:remove')")
    @Log(title = "数采协议管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{agreement_ids}")
    public AjaxResult remove(@PathVariable String[] agreement_ids)
    {
        return toAjax(agreementService.deleteAgreementByAgreement_ids(agreement_ids));
    }

    /**
     * 导出协议数据
     */
    @Log(title = "协议信息", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('collection:agreement:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Agreement agreement)
    {
        List<Agreement> agreementList = agreementService.selectAgreementList(agreement);
        ExcelUtil<Agreement> util = new ExcelUtil<Agreement>(Agreement.class);
        util.exportExcel(response, agreementList, "协议数据");
    }
}

package com.ruoyi.web.controller.device;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.ToyoMessage;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.service.PlanService;
import com.ruoyi.web.service.ToyoMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/15 15:06
 * @Code : bug and work
 * @Description : 东洋机台数据控制层
 */
@RestController
@RequestMapping("/device/toyomessage")
public class ToyoMessageController extends BaseController {

    @Autowired
    private ToyoMessageService toyoMessageService;

    /**
     * 获取东洋机台数据列表
     */
    @PreAuthorize("@ss.hasPermi('device:toyomessage:list')")
    @GetMapping("/list")
    public TableDataInfo list(ToyoMessage toyoMessage)
    {
//        startPage();
        List<ToyoMessage> toyoMessageList = toyoMessageService.selectToyoMessageList(toyoMessage);

        return getDataTable(toyoMessageList);
    }

    @Log(title = "东洋数据管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('device:toyomessage:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, ToyoMessage toyoMessage)
    {
        List<ToyoMessage> list = toyoMessageService.selectToyoMessageList2(toyoMessage);
        ExcelUtil<ToyoMessage> util = new ExcelUtil<ToyoMessage>(ToyoMessage.class);
        util.exportExcel(response, list, "机台数据");
    }
}

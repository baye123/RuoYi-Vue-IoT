package com.ruoyi.web.controller.device;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.domain.Shpmachud;
import com.ruoyi.web.domain.vo.PlanVo;
import com.ruoyi.web.service.ShpmachudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/9 11:05
 * @Code : bug and work
 * @Description : 机台流水单控制类
 */
@RestController
@RequestMapping("/device/shpmachud")
public class ShpmachudController extends BaseController {

    @Autowired
    ShpmachudService shpmachudService;


    /**
     * 获取计划生产列表
     */
    @PreAuthorize("@ss.hasPermi('device:shpmachud:list')")
    @GetMapping("/list")
    public TableDataInfo list(Shpmachud shpmachud)
    {
        startPage();
        List<Shpmachud> shpmachudList = shpmachudService.selectShpmachudList(shpmachud);
        return getDataTable(shpmachudList);
    }

}

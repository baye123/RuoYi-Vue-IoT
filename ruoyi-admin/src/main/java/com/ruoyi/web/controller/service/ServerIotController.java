package com.ruoyi.web.controller.service;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.SocketMsg;
import com.ruoyi.web.service.SocketMsgService;
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
 * @Date : 2023/4/24 16:24
 * @Code : bug and work
 * @Description : Iot控制类
 */
@RestController
@RequestMapping("/server/iot")
public class ServerIotController extends BaseController {
    @Autowired
    private SocketMsgService socketMsgService;

    /**
     * 获取菜单列表
     */
    @PreAuthorize("@ss.hasPermi('server:iot:list')")
    @GetMapping("/list")
    public TableDataInfo list(SocketMsg socketMsg)
    {
        startPage();
        List<SocketMsg> socketMsgList = socketMsgService.selectSocketMsgList(socketMsg);
        return getDataTable(socketMsgList);
    }

    @Log(title = "设备联机", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('server:iot:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SocketMsg socketMsg)
    {
        List<SocketMsg> list = socketMsgService.selectSocketMsgList(socketMsg);
        ExcelUtil<SocketMsg> util = new ExcelUtil<SocketMsg>(SocketMsg.class);
        util.exportExcel(response, list, "设备数据");
    }
}

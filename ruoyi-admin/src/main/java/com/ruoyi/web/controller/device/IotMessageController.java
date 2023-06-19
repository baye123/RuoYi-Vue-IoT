package com.ruoyi.web.controller.device;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.vo.IotMessage;
import com.ruoyi.web.service.InformationService;
import com.ruoyi.web.service.IotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/19 9:09
 * @Code : bug and work
 * @Description : Iot合模历史控制类
 */
@RestController
@RequestMapping("/device/history")
public class IotMessageController extends BaseController {
    @Autowired
    private IotMessageService iotMessageService;

    /**
     * 获取设备列表
     */
    @PreAuthorize("@ss.hasPermi('device:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(IotMessage iotMessage)
    {
//        startPage();
        List<IotMessage> iotMessageList = iotMessageService.selectIotMessageList(iotMessage);
        for(IotMessage i : iotMessageList){
            i.setAction("合模");
            i.setIllustrate("生产");
        }
        return getDataTable(iotMessageList);
    }

}

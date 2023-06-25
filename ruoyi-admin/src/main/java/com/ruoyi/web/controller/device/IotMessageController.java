package com.ruoyi.web.controller.device;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.Shpmachud;
import com.ruoyi.web.domain.vo.IotMessage;
import com.ruoyi.web.service.InformationService;
import com.ruoyi.web.service.IotMessageService;
import com.ruoyi.web.service.ShpmachudService;
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

    @Autowired
    private ShpmachudService shpmachudService;

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
            Shpmachud shpmachud = shpmachudService.selectShpmachudByDevice_idAndTime(i.getDevice_id(),i.getTime());
            i.setCpo(shpmachud.getCpo());
            i.setMold_id(shpmachud.getMold_id());
            i.setProduct_id(shpmachud.getProduct_id());
            i.setAction("合模");
            i.setIllustrate(shpmachud.getCls());
        }
        return getDataTable(iotMessageList);
    }

}

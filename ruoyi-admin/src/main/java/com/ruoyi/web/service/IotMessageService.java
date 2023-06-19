package com.ruoyi.web.service;

import com.ruoyi.web.domain.Device;
import com.ruoyi.web.domain.vo.IotMessage;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/19 9:33
 * @Code : bug and work
 * @Description : Iot历史模块服务类
 */
public interface IotMessageService {
    /**
     *
     * @param iotMessage
     * @return
     */
    public List<IotMessage> selectIotMessageList(IotMessage iotMessage);
}

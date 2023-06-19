package com.ruoyi.web.service;

import com.ruoyi.web.domain.SocketMsg;
import com.ruoyi.web.domain.ToyoMessage;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/15 15:11
 * @Code : bug and work
 * @Description : 东洋机台数据服务层
 */
public interface ToyoMessageService {
    /**
     *
     * @param toyoMessage
     * @return
     */
    public List<ToyoMessage> selectToyoMessageList(ToyoMessage toyoMessage);
}

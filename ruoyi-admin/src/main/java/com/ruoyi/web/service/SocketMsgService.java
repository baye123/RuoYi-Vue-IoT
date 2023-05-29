package com.ruoyi.web.service;

import com.ruoyi.web.domain.SocketMsg;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/4/25 16:09
 * @Code : bug and work
 * @Description : 消息服务类
 */
public interface SocketMsgService {
    /**
     *
     * @param socketMsg
     * @return
     */
    public List<SocketMsg> selectSocketMsgList(SocketMsg socketMsg);
}

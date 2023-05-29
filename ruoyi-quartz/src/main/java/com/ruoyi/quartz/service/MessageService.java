package com.ruoyi.quartz.service;

import com.ruoyi.quartz.domain.Message;

/**
 * @Author : baye
 * @Date : 2023/5/24 14:29
 * @Code : bug and work
 * @Description : 消息服务类
 */
public interface MessageService {
    /**
     * 新增保存消息信息
     *
     * @param message 消息信息
     * @return 结果
     */
    public int insertMessage(Message message);
}

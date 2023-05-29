package com.ruoyi.quartz.service.impl;

import com.ruoyi.quartz.domain.Message;
import com.ruoyi.quartz.mapper.MessageMapper;
import com.ruoyi.quartz.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : baye
 * @Date : 2023/5/25 9:30
 * @Code : bug and work
 * @Description :
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int insertMessage(Message message){
        if (messageMapper.existTable(message.getTable()) == 0) {
            messageMapper.createNewTable(message.getTable());
        }
        return messageMapper.insertMessage(message);


    }
}

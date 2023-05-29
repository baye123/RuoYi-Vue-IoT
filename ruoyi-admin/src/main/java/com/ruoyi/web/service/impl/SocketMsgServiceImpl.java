package com.ruoyi.web.service.impl;

import com.ruoyi.web.domain.SocketMsg;
import com.ruoyi.web.mapper.SocketMsgMapper;
import com.ruoyi.web.service.SocketMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/4/25 16:10
 * @Code : bug and work
 * @Description :
 */
@Service
public class SocketMsgServiceImpl implements SocketMsgService {

    @Autowired
    SocketMsgMapper socketMsgMapper;

    @Override
    public List<SocketMsg> selectSocketMsgList(SocketMsg socketMsg){
        return socketMsgMapper.selectSocketMsgList(socketMsg);
    }
}

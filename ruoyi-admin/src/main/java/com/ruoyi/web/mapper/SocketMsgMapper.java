package com.ruoyi.web.mapper;


import com.ruoyi.web.domain.SocketMsg;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/4/25 16:21
 * @Code : bug and work
 * @Description :
 */
public interface SocketMsgMapper {
    /**
     * 查询设备消息列表
     *
     * @param socketMsg 设备消息信息
     * @return 消息集合
     */
    public List<SocketMsg> selectSocketMsgList(SocketMsg socketMsg);
}

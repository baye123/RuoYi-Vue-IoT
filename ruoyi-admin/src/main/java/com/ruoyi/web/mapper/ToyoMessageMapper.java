package com.ruoyi.web.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.web.domain.SocketMsg;
import com.ruoyi.web.domain.ToyoMessage;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/15 15:16
 * @Code : bug and work
 * @Description :
 */

public interface ToyoMessageMapper {
    /**
     * 查询东洋机台数据消息列表
     *
     * @param toyoMessage 洋机台数据消息
     * @return 消息集合
     */
    public List<ToyoMessage> selectToyoMessageList(ToyoMessage toyoMessage);
}

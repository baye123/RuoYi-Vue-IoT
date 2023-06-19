package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.vo.IotMessage;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/19 9:40
 * @Code : bug and work
 * @Description :
 */
public interface IotMessageMapper {
    /**
     * 查询合模历史数据列表
     *
     * @param iotMessage 设备信息
     * @return 设备集合
     */
    public List<IotMessage> selectIotMessageList(IotMessage iotMessage);
}

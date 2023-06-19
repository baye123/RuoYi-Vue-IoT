package com.ruoyi.web.service.impl;

import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.vo.IotMessage;
import com.ruoyi.web.mapper.InformationMapper;
import com.ruoyi.web.mapper.IotMessageMapper;
import com.ruoyi.web.service.IotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/19 9:38
 * @Code : bug and work
 * @Description :
 */
@Service
public class IotMessageServiceImpl implements IotMessageService {
    @Autowired
    IotMessageMapper iotMessageMapper;
    @Autowired
    InformationMapper informationMapper;
    public List<IotMessage> selectIotMessageList(IotMessage iotMessage){
        //根据设备编号查询设备IP
        String IP = informationMapper.getIpByDevice_id(iotMessage.getDevice_id());
        iotMessage.setIp(IP);

        //根据IP和协议表关系，查询相关数据表
        String tableName = "equipment_" + iotMessage.getIp().replace(".","_");
        iotMessage.setTableName(tableName);
        PageUtils.startPage();
        return iotMessageMapper.selectIotMessageList(iotMessage);
    }

}

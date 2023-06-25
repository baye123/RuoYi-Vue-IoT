package com.ruoyi.web.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.web.domain.ToyoMessage;
import com.ruoyi.web.mapper.SocketMsgMapper;
import com.ruoyi.web.mapper.ToyoMessageMapper;
import com.ruoyi.web.service.ToyoMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/6/15 15:12
 * @Code : bug and work
 * @Description :
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class ToyoMessageServiceImpl implements ToyoMessageService {

    @Autowired
    ToyoMessageMapper toyoMessageMapper;

    public List<ToyoMessage> selectToyoMessageList(ToyoMessage toyoMessage){
        String tableName = new String();
        if(toyoMessage.getDevice_no().equals("A-037|Z2022-715")){
            tableName = "im_data.im37_33molding";
        }
        else if(toyoMessage.getDevice_no().equals("A-038|Z2022-716")){
            tableName = "im_data.im38_33molding";
        }
        else if(toyoMessage.getDevice_no().equals("A-039|Z2020-601")){
            tableName = "im_data.im39_33molding";
        }
        else if(toyoMessage.getDevice_no().equals("A-041|Z2020-603")){
            tableName = "im_data.im41_33molding";
        }

        toyoMessage.setDevice_no(tableName);

        PageUtils.startPage();
        return toyoMessageMapper.selectToyoMessageList(toyoMessage);
    }
    public List<ToyoMessage> selectToyoMessageList2(ToyoMessage toyoMessage){
        String tableName = new String();
        if(toyoMessage.getDevice_no().equals("A-037|Z2022-715")){
            tableName = "im_data.im37_33molding";
        }
        else if(toyoMessage.getDevice_no().equals("A-038|Z2022-716")){
            tableName = "im_data.im38_33molding";
        }
        else if(toyoMessage.getDevice_no().equals("A-039|Z2020-601")){
            tableName = "im_data.im39_33molding";
        }
        else if(toyoMessage.getDevice_no().equals("A-041|Z2020-603")){
            tableName = "im_data.im41_33molding";
        }

        toyoMessage.setDevice_no(tableName);


        return toyoMessageMapper.selectToyoMessageList(toyoMessage);
    }

}

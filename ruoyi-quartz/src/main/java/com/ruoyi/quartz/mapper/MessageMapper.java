package com.ruoyi.quartz.mapper;

import com.ruoyi.quartz.domain.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/5/25 9:39
 * @Code : bug and work
 * @Description :
 */
public interface MessageMapper {
    //保存一条设备类数据
    int insertMessage(Message message);
    //检查表是否存在
    int existTable(String tableName);
    //创建新的表
    int createNewTable(@Param("tableName") String tableName);

}

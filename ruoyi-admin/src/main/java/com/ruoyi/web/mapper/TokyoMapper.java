package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Tokyo_33;
import com.ruoyi.web.domain.Tokyo_46;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : baye
 * @Date : 2023/7/3 8:29
 * @Code : bug and work
 * @Description :
 */
@Repository
@Mapper
public interface TokyoMapper {
    int saveTokyo(Tokyo_33 tokyo_33);
    int saveTokyo46(Tokyo_46 tokyo_46);
    //检查东洋设备表是否存在
    int existTable(String tableName);
    //创建新的东洋表
    int createNewTable(@Param("table") String tableName);
    //创建新的东洋46号消息表
    int createNewTable46(@Param("table") String tableName);

    //查询东洋设备ip，通过设备编号
    String getIpByDevice_id(@Param("device_id")String device_id);

    //查询东洋数据
    List<Tokyo_33> selectTokyo_33List(Tokyo_33 tokyo_33);

    //查询东洋46数据
    List<Tokyo_46> selectTokyo_46List(Tokyo_46 tokyo_46);


}

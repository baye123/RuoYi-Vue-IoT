package com.ruoyi.quartz.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author : baye
 * @Date : 2023/4/25 15:24
 * @Code : bug and work
 * @Description : Iot消息实体类
 */
public class Message extends BaseEntity {

    private Long id;

    private long  time_stamp;//时间戳

    private String IP;

    @Excel(name = "设备名称")
    private String equipmentId; //设备id

    private String table; //对应表名

    @Excel(name = "安灯状态")
    private String light; //安灯状态

    @Excel(name = "当前状态值")
    private String status_value; //当前状态值

    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String time;//时间

    private String DI_1;

    private String DI_2;

    private String DI_3;

    private String DI_4;

    private String DI_5;

    private String DI_6;

    private String DI_7;

    private String DI_8;

    @Excel(name = "原始消息" ,width = 30)
    private String original_information; //原始消息

    private int cycle1;//合模周期

    private int cycle2;//合模间隔周期

    private int cycle3;//第一次合模开始到第二次合模开始大周期

    private int mold_closing; //合模次数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getStatus_value() {
        return status_value;
    }

    public void setStatus_value(String status_value) {
        this.status_value = status_value;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDI_1() {
        return DI_1;
    }

    public void setDI_1(String DI_1) {
        this.DI_1 = DI_1;
    }

    public String getDI_2() {
        return DI_2;
    }

    public void setDI_2(String DI_2) {
        this.DI_2 = DI_2;
    }

    public String getDI_3() {
        return DI_3;
    }

    public void setDI_3(String DI_3) {
        this.DI_3 = DI_3;
    }

    public String getDI_4() {
        return DI_4;
    }

    public void setDI_4(String DI_4) {
        this.DI_4 = DI_4;
    }

    public String getDI_5() {
        return DI_5;
    }

    public void setDI_5(String DI_5) {
        this.DI_5 = DI_5;
    }

    public String getDI_6() {
        return DI_6;
    }

    public void setDI_6(String DI_6) {
        this.DI_6 = DI_6;
    }

    public String getDI_7() {
        return DI_7;
    }

    public void setDI_7(String DI_7) {
        this.DI_7 = DI_7;
    }

    public String getDI_8() {
        return DI_8;
    }

    public void setDI_8(String DI_8) {
        this.DI_8 = DI_8;
    }

    public String getOriginal_information() {
        return original_information;
    }

    public void setOriginal_information(String original_information) {
        this.original_information = original_information;
    }

    public int getCycle1() {
        return cycle1;
    }

    public void setCycle1(int cycle1) {
        this.cycle1 = cycle1;
    }

    public int getCycle2() {
        return cycle2;
    }

    public void setCycle2(int cycle2) {
        this.cycle2 = cycle2;
    }

    public int getCycle3() {
        return cycle3;
    }

    public void setCycle3(int cycle3) {
        this.cycle3 = cycle3;
    }

    public int getMold_closing() {
        return mold_closing;
    }

    public void setMold_closing(int mold_closing) {
        this.mold_closing = mold_closing;
    }
}

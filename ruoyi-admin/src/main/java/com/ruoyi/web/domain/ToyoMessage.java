package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * @Author : baye
 * @Date : 2023/6/15 14:30
 * @Code : bug and work
 * @Description : 东洋机台数据消息实体类
 */
public class ToyoMessage extends BaseEntity {

    private int data_id; //数据库自增id

    private String device_no;//东洋机台 机号

    @Excel(name = "数据接收时间")
    private String recv_time;//数据接收时的时间戳（时区格式）

    private String recv_time2; //用于查询确定查询时间范围 等价于数据接收时间戳
    @Excel(name = "成形数")
    private int id_molding;//成型数
    @Excel(name = "设备发送数据时间")
    private String dev_time;//数据发出时，设备机台本身的发出时间（时区格式）
    @Excel(name = "电热温度1")
    private BigDecimal t_eh1;//电热温度1
    @Excel(name = "电热温度2")
    private BigDecimal t_eh2;//电热温度2
    @Excel(name = "电热温度3")
    private BigDecimal t_eh3;//电热温度3
    @Excel(name = "电热温度4")
    private BigDecimal t_eh4;//电热温度4
    @Excel(name = "电热温度5")
    private BigDecimal t_eh5;//电热温度5
    @Excel(name = "料斗温度")
    private BigDecimal t_hopper;//料斗温度
    @Excel(name = "1次压力")
    private BigDecimal pressure1;//1次压力
    @Excel(name = "2次压力")
    private BigDecimal pressure2;//2次压力
    @Excel(name = "3次压力")
    private BigDecimal pressure3;//3次压力
    @Excel(name = "最大压力")
    private BigDecimal pressure_max;//最大压力
    @Excel(name = "树脂压")
    private BigDecimal pressure_resin;//树脂压
    @Excel(name = "V-P切换位置")
    private BigDecimal position_vp;//V-P切换位置
    @Excel(name = "余量位置")
    private BigDecimal position_margin;//余量位置
    @Excel(name = "射出位置")
    private BigDecimal position_shooting;//射出位置
    @Excel(name = "最大速度")
    private BigDecimal speed_max;//最大速度
    @Excel(name = "周期时间")
    private BigDecimal timing_cycle;//周期时间
    @Excel(name = "填充时间")
    private BigDecimal timing_fill;//填充时间
    @Excel(name = "计量时间")
    private BigDecimal timing_metering;//计量时间
    @Excel(name = "冷却时间")
    private BigDecimal timing_cooling;//冷却时间

    public int getData_id() {
        return data_id;
    }

    public void setData_id(int data_id) {
        this.data_id = data_id;
    }

    public String getDevice_no() {
        return device_no;
    }

    public void setDevice_no(String device_no) {
        this.device_no = device_no;
    }

    public String getRecv_time() {
        return recv_time;
    }

    public void setRecv_time(String recv_time) {
        this.recv_time = recv_time;
    }

    public String getRecv_time2() {
        return recv_time2;
    }

    public void setRecv_time2(String recv_time2) {
        this.recv_time2 = recv_time2;
    }

    public int getId_molding() {
        return id_molding;
    }

    public void setId_molding(int id_molding) {
        this.id_molding = id_molding;
    }

    public String getDev_time() {
        return dev_time;
    }

    public void setDev_time(String dev_time) {
        this.dev_time = dev_time;
    }

    public BigDecimal getT_eh1() {
        return t_eh1;
    }

    public void setT_eh1(BigDecimal t_eh1) {
        this.t_eh1 = t_eh1;
    }

    public BigDecimal getT_eh2() {
        return t_eh2;
    }

    public void setT_eh2(BigDecimal t_eh2) {
        this.t_eh2 = t_eh2;
    }

    public BigDecimal getT_eh3() {
        return t_eh3;
    }

    public void setT_eh3(BigDecimal t_eh3) {
        this.t_eh3 = t_eh3;
    }

    public BigDecimal getT_eh4() {
        return t_eh4;
    }

    public void setT_eh4(BigDecimal t_eh4) {
        this.t_eh4 = t_eh4;
    }

    public BigDecimal getT_eh5() {
        return t_eh5;
    }

    public void setT_eh5(BigDecimal t_eh5) {
        this.t_eh5 = t_eh5;
    }

    public BigDecimal getT_hopper() {
        return t_hopper;
    }

    public void setT_hopper(BigDecimal t_hopper) {
        this.t_hopper = t_hopper;
    }

    public BigDecimal getPressure1() {
        return pressure1;
    }

    public void setPressure1(BigDecimal pressure1) {
        this.pressure1 = pressure1;
    }

    public BigDecimal getPressure2() {
        return pressure2;
    }

    public void setPressure2(BigDecimal pressure2) {
        this.pressure2 = pressure2;
    }

    public BigDecimal getPressure3() {
        return pressure3;
    }

    public void setPressure3(BigDecimal pressure3) {
        this.pressure3 = pressure3;
    }

    public BigDecimal getPressure_max() {
        return pressure_max;
    }

    public void setPressure_max(BigDecimal pressure_max) {
        this.pressure_max = pressure_max;
    }

    public BigDecimal getPressure_resin() {
        return pressure_resin;
    }

    public void setPressure_resin(BigDecimal pressure_resin) {
        this.pressure_resin = pressure_resin;
    }

    public BigDecimal getPosition_vp() {
        return position_vp;
    }

    public void setPosition_vp(BigDecimal position_vp) {
        this.position_vp = position_vp;
    }

    public BigDecimal getPosition_margin() {
        return position_margin;
    }

    public void setPosition_margin(BigDecimal position_margin) {
        this.position_margin = position_margin;
    }

    public BigDecimal getPosition_shooting() {
        return position_shooting;
    }

    public void setPosition_shooting(BigDecimal position_shooting) {
        this.position_shooting = position_shooting;
    }

    public BigDecimal getSpeed_max() {
        return speed_max;
    }

    public void setSpeed_max(BigDecimal speed_max) {
        this.speed_max = speed_max;
    }

    public BigDecimal getTiming_cycle() {
        return timing_cycle;
    }

    public void setTiming_cycle(BigDecimal timing_cycle) {
        this.timing_cycle = timing_cycle;
    }

    public BigDecimal getTiming_fill() {
        return timing_fill;
    }

    public void setTiming_fill(BigDecimal timing_fill) {
        this.timing_fill = timing_fill;
    }

    public BigDecimal getTiming_metering() {
        return timing_metering;
    }

    public void setTiming_metering(BigDecimal timing_metering) {
        this.timing_metering = timing_metering;
    }

    public BigDecimal getTiming_cooling() {
        return timing_cooling;
    }

    public void setTiming_cooling(BigDecimal timing_cooling) {
        this.timing_cooling = timing_cooling;
    }
}

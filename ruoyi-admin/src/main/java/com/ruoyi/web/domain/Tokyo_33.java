package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : baye
 * @Date : 2023/6/29 16:45
 * @Code : bug and work
 * @Description : 东洋机-33识别数据类
 */
public class  Tokyo_33 extends BaseEntity {
    private Long id; //自增

    private String table; //对应表名

    private String device_id;//东洋机台 编号

    @Excel(name = "数据接收时间")
    private Date recv_time;//数据接收时间

    @Excel(name = "数据接收时间戳")
    private int recv_unixts;//数据接收时间戳

    @Excel(name = "成形计数")
    private int id_molding; //成形计数

    @Excel(name = "设备时间")
    private Date dev_time;//设备时间

    @Excel(name = "电热1")
    private BigDecimal t_eh1;//电热1
    @Excel(name = "电热2")
    private BigDecimal t_eh2;//电热2
    @Excel(name = "电热3")
    private BigDecimal t_eh3;//电热3
    @Excel(name = "电热4")
    private BigDecimal t_eh4;//电热4
    @Excel(name = "电热5")
    private BigDecimal t_eh5;//电热5
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

    private String original_data_hex;//原始数据hex

    private byte[] original_data_bin;//原始数据byte

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public Date getRecv_time() {
        return recv_time;
    }

    public void setRecv_time(Date recv_time) {
        this.recv_time = recv_time;
    }

    public int getRecv_unixts() {
        return recv_unixts;
    }

    public void setRecv_unixts(int recv_unixts) {
        this.recv_unixts = recv_unixts;
    }

    public int getId_molding() {
        return id_molding;
    }

    public void setId_molding(int id_molding) {
        this.id_molding = id_molding;
    }

    public Date getDev_time() {
        return dev_time;
    }

    public void setDev_time(Date dev_time) {
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

    public String getOriginal_data_hex() {
        return original_data_hex;
    }

    public void setOriginal_data_hex(String original_data_hex) {
        this.original_data_hex = original_data_hex;
    }

    public byte[] getOriginal_data_bin() {
        return original_data_bin;
    }

    public void setOriginal_data_bin(byte[] original_data_bin) {
        this.original_data_bin = original_data_bin;
    }
}

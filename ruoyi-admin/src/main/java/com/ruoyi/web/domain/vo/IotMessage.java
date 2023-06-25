package com.ruoyi.web.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author : baye
 * @Date : 2023/6/16 17:16
 * @Code : bug and work
 * @Description : Iot原始数据类
 */
public class IotMessage extends BaseEntity {
    private long id;
    private String tableName; //要查询的协议数据表名称
    private String device_id;//设备编号
    private String device_type;//设备别名

    private String light;//安灯状态
    private String cpo;//节点

    private String product_id;//料号

    private String mold_id;//模号
    private String time;//合模时 时间
    private String status_value;//解析后的位图
    private String agreement_id;//协议编号 C、D
    private String ip; //ip地址
    private String action; //动作 （合模）
    private String illustrate; //说明

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getCpo() {
        return cpo;
    }

    public void setCpo(String cpo) {
        this.cpo = cpo;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getMold_id() {
        return mold_id;
    }

    public void setMold_id(String mold_id) {
        this.mold_id = mold_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus_value() {
        return status_value;
    }

    public void setStatus_value(String status_value) {
        this.status_value = status_value;
    }

    public String getAgreement_id() {
        return agreement_id;
    }

    public void setAgreement_id(String agreement_id) {
        this.agreement_id = agreement_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }
}

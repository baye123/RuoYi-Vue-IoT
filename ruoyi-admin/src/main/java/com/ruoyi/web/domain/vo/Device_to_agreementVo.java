package com.ruoyi.web.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author : baye
 * @Date : 2023/5/18 16:49
 * @Code : bug and work
 * @Description :设备协议关联实体关联类
 */
public class Device_to_agreementVo extends BaseEntity {
    private Long id;//自增主键

    @Excel(name = "协议编号")
    private String agreement_id;//协议编号

    @Excel(name = "协议类型")
    private String agreement_type;//协议类型
    @Excel(name = "设备编号")
    private String device_id;//设备id

    @Excel(name = "设备名称")
    private String device_name;//设备名称

    @Excel(name = "协议IP")
    private String ip; //Iot设备的IP地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgreement_id() {
        return agreement_id;
    }

    public void setAgreement_id(String agreement_id) {
        this.agreement_id = agreement_id;
    }

    public String getAgreement_type() {
        return agreement_type;
    }

    public void setAgreement_type(String agreement_type) {
        this.agreement_type = agreement_type;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

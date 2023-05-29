package com.ruoyi.quartz.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author : baye
 * @Date : 2023/5/12 14:44
 * @Code : bug and work
 * @Description : 数采协议实体类
 */
public class AgreementVo extends BaseEntity {
    private Long id;//自增主键

    private String agreement_id;//协议编号

    private String agreement_type;//协议类型

    private String ip;//ip地址

    private String port;//访问端口

    private int agreement_status;//协议状态 是否生效

    private String create_by;//创建者

    private String create_time;//创建时间

    private String update_by;//修改者

    private String update_time;//修改时间

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getAgreement_status() {
        return agreement_status;
    }

    public void setAgreement_status(int agreement_status) {
        this.agreement_status = agreement_status;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}

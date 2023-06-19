package com.ruoyi.web.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author : baye
 * @Date : 2023/6/9 10:54
 * @Code : bug and work
 * @Description : 机台流水实体类
 */
public class Shpmachud extends BaseEntity {
    private Long id;

    private String cls;//流水类别 类别(1:上机 2：生产 3：上模 4：调机 5：初品 6：IPQC判定 7：初品判定完成 8：下模 9：模具保养)

    private String cpo;//节点

    private String device_id; //设备编号

    private String product_id; //产品编号

    private String mold_id; //模号编号

    private String dowid; //操作人

    private String dotime; //开始时间

    private String endtime; //结束时间

    private String endwid; //结案人

    private String downcls; // 总耗时

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getCpo() {
        return cpo;
    }

    public void setCpo(String cpo) {
        this.cpo = cpo;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
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

    public String getDowid() {
        return dowid;
    }

    public void setDowid(String dowid) {
        this.dowid = dowid;
    }

    public String getDotime() {
        return dotime;
    }

    public void setDotime(String dotime) {
        this.dotime = dotime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getEndwid() {
        return endwid;
    }

    public void setEndwid(String endwid) {
        this.endwid = endwid;
    }

    public String getDowncls() {
        return downcls;
    }

    public void setDowncls(String downcls) {
        this.downcls = downcls;
    }
}

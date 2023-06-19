package com.ruoyi.web.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author : baye
 * @Date : 2023/6/12 9:53
 * @Code : bug and work
 * @Description : 实时生产数据类
 */
public class Produce extends BaseEntity {
    private String cpo; //生产节点

    private String product_id;//料号

    private String device_id;//设备号

    private String device_type;//查询设备别名

    private String mold_id; //模号

    private String workshop;//车间

    private String dotime; //开始时间

    private String dowid; //操作人

    private String endwid;//结束人

    private String endtime; //结束时间

    private String worksheet; //穴数

    private String downcls; //总耗时

    private int planned_production_quantity;//计划生产数量

    private int numrp; //新峰计数器


    private int actual_production_quantity;//本系统计算生产数量计数器

    private int difference_value;//计算差异值

    private String difference_proportion;//计算差异率

    private int actual_cycle;//大周期

    private String refresh_time; //更新时间

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

    public String getEndwid() {
        return endwid;
    }

    public void setEndwid(String endwid) {
        this.endwid = endwid;
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

    public String getWorksheet() {
        return worksheet;
    }

    public void setWorksheet(String worksheet) {
        this.worksheet = worksheet;
    }

    public String getDowncls() {
        return downcls;
    }

    public void setDowncls(String downcls) {
        this.downcls = downcls;
    }

    public int getPlanned_production_quantity() {
        return planned_production_quantity;
    }

    public void setPlanned_production_quantity(int planned_production_quantity) {
        this.planned_production_quantity = planned_production_quantity;
    }

    public int getNumrp() {
        return numrp;
    }

    public void setNumrp(int numrp) {
        this.numrp = numrp;
    }

    public int getActual_production_quantity() {
        return actual_production_quantity;
    }

    public void setActual_production_quantity(int actual_production_quantity) {
        this.actual_production_quantity = actual_production_quantity;
    }

    public int getActual_cycle() {
        return actual_cycle;
    }

    public void setActual_cycle(int actual_cycle) {
        this.actual_cycle = actual_cycle;
    }

    public String getRefresh_time() {
        return refresh_time;
    }

    public void setRefresh_time(String refresh_time) {
        this.refresh_time = refresh_time;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public int getDifference_value() {
        return difference_value;
    }

    public void setDifference_value(int difference_value) {
        this.difference_value = difference_value;
    }

    public String getDifference_proportion() {
        return difference_proportion;
    }
    public void setDifference_proportion(String difference_proportion) {
        this.difference_proportion = difference_proportion;
    }
}

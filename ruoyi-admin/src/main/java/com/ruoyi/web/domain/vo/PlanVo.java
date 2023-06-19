package com.ruoyi.web.domain.vo;

/**
 * @Author : baye
 * @Date : 2023/6/2 15:21
 * @Code : bug and work
 * @Description : 计划生产实体类
 */
public class PlanVo {

    private Long id;

    private String table;//应该查询的表名

    private String cpo;//节点

    private String product_id;//产品编号\料号

    private String device_id; //设备编号

    private String device_type; //设备别名

    private String workshop; //所在车间

    private String mold_id; //模具编号\模号

    private String production_start_time; //上模时间

    private String production_end_time; //下模时间

    private int produce_number; //取数

    private int production_status;//状态 1：生产中 0：等待中

    private int planned_production_quantity;//计划生产数量

    private int actual_production_quantity; //实际生产数量

    private int difference_value;//差异值

    private int produce_cycle; //计划生产周期

    private int actual_cycle; //实际生产周期

    private String difference_proportion;//计算差异率


    private String refresh_time; //更新时间

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

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getMold_id() {
        return mold_id;
    }

    public void setMold_id(String mold_id) {
        this.mold_id = mold_id;
    }

    public String getProduction_start_time() {
        return production_start_time;
    }

    public void setProduction_start_time(String production_start_time) {
        this.production_start_time = production_start_time;
    }

    public String getProduction_end_time() {
        return production_end_time;
    }

    public void setProduction_end_time(String production_end_time) {
        this.production_end_time = production_end_time;
    }

    public int getProduce_number() {
        return produce_number;
    }

    public void setProduce_number(int produce_number) {
        this.produce_number = produce_number;
    }

    public int getProduction_status() {
        return production_status;
    }

    public void setProduction_status(int production_status) {
        this.production_status = production_status;
    }

    public int getPlanned_production_quantity() {
        return planned_production_quantity;
    }

    public void setPlanned_production_quantity(int planned_production_quantity) {
        this.planned_production_quantity = planned_production_quantity;
    }

    public int getActual_production_quantity() {
        return actual_production_quantity;
    }

    public void setActual_production_quantity(int actual_production_quantity) {
        this.actual_production_quantity = actual_production_quantity;
    }

    public int getProduce_cycle() {
        return produce_cycle;
    }

    public void setProduce_cycle(int produce_cycle) {
        this.produce_cycle = produce_cycle;
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

    @Override
    public String toString() {
        return "PlanVo{" +
                "id=" + id +
                ", table='" + table + '\'' +
                ", product_id='" + product_id + '\'' +
                ", device_id='" + device_id + '\'' +
                ", mold_id='" + mold_id + '\'' +
                ", production_start_time='" + production_start_time + '\'' +
                ", production_end_time='" + production_end_time + '\'' +
                ", produce_number=" + produce_number +
                ", production_status=" + production_status +
                ", planned_production_quantity=" + planned_production_quantity +
                ", actual_production_quantity=" + actual_production_quantity +
                ", produce_cycle=" + produce_cycle +
                ", actual_cycle=" + actual_cycle +
                ", refresh_time='" + refresh_time + '\'' +
                '}';
    }
}

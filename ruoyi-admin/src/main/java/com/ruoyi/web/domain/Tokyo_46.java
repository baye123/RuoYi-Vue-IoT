package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : baye
 * @Date : 2023/7/7 11:25
 * @Code : bug and work
 * @Description : 东洋46数据类别
 */
public class Tokyo_46 extends BaseEntity {
    private Long id; //自增

    private String table; //对应表名

    private String device_id;//东洋机台 编号
    @Excel(name = "数据接收时间")
    private Date recv_time;//数据接收时间
    @Excel(name = "数据接收时间戳")
    private int recv_unixts;//数据接收时间戳
    @Excel(name = "设备时间")
    private Date dev_time;//设备时间
    @Excel(name = "机种名")
    private String device_type;//机种名
    @Excel(name = "运转模式编码")
    private int operating_mode_coding;//运转模式编码
    @Excel(name = "运转模式名")
    private String operating_mode;//运转模式名
    @Excel(name = "产品名")
    private String product_name;//产品名
    @Excel(name = "模号")
    private String mold_id;//模号
    @Excel(name = "模数")
    private int id_molding;//模数
    @Excel(name = "循环时间")
    private String cycle_time;//循环时间
    @Excel(name = "运转时间")
    private String operating_time;//运转时间
    @Excel(name = "停止时间")
    private String stop_time;//停止时间
    @Excel(name = "不良数")
    private int ng_number;//不良数
    @Excel(name = "不良率")
    private BigDecimal ng_rate;//不良率
    @Excel(name = "生产数")
    private int product_number;//生产数
    @Excel(name = "生产率")
    private BigDecimal product_rate;//生产率
    @Excel(name = "运转率")
    private BigDecimal operating_rate;//运转率
    @Excel(name = "进展")
    private BigDecimal evolve;//进展

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

    public Date getDev_time() {
        return dev_time;
    }

    public void setDev_time(Date dev_time) {
        this.dev_time = dev_time;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public int getOperating_mode_coding() {
        return operating_mode_coding;
    }

    public void setOperating_mode_coding(int operating_mode_coding) {
        this.operating_mode_coding = operating_mode_coding;
    }

    public String getOperating_mode() {
        return operating_mode;
    }

    public void setOperating_mode(String operating_mode) {
        this.operating_mode = operating_mode;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getMold_id() {
        return mold_id;
    }

    public void setMold_id(String mold_id) {
        this.mold_id = mold_id;
    }

    public int getId_molding() {
        return id_molding;
    }

    public void setId_molding(int id_molding) {
        this.id_molding = id_molding;
    }

    public String getCycle_time() {
        return cycle_time;
    }

    public void setCycle_time(String cycle_time) {
        this.cycle_time = cycle_time;
    }

    public String getOperating_time() {
        return operating_time;
    }

    public void setOperating_time(String operating_time) {
        this.operating_time = operating_time;
    }

    public String getStop_time() {
        return stop_time;
    }

    public void setStop_time(String stop_time) {
        this.stop_time = stop_time;
    }

    public int getNg_number() {
        return ng_number;
    }

    public void setNg_number(int ng_number) {
        this.ng_number = ng_number;
    }

    public BigDecimal getNg_rate() {
        return ng_rate;
    }

    public void setNg_rate(BigDecimal ng_rate) {
        this.ng_rate = ng_rate;
    }

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    public BigDecimal getProduct_rate() {
        return product_rate;
    }

    public void setProduct_rate(BigDecimal product_rate) {
        this.product_rate = product_rate;
    }

    public BigDecimal getOperating_rate() {
        return operating_rate;
    }

    public void setOperating_rate(BigDecimal operating_rate) {
        this.operating_rate = operating_rate;
    }

    public BigDecimal getEvolve() {
        return evolve;
    }

    public void setEvolve(BigDecimal evolve) {
        this.evolve = evolve;
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

package com.ruoyi.web.domain;

/**
 * @Author : baye
 * @Date : 2023/4/28 14:05
 * @Code : bug and work
 * @Description : 设备配置实体类
 */
public class EquipmentConfig {

    private Long id;

    private String equipment_id; //设备名称

    private String exchang_name;//交换机名称

    private String routing_key;//路由键名称

    private String queue_name;//队列名称

    private String create_time;//配置创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getExchang_name() {
        return exchang_name;
    }

    public void setExchang_name(String exchang_name) {
        this.exchang_name = exchang_name;
    }

    public String getRouting_key() {
        return routing_key;
    }

    public void setRouting_key(String routing_key) {
        this.routing_key = routing_key;
    }

    public String getQueue_name() {
        return queue_name;
    }

    public void setQueue_name(String queue_name) {
        this.queue_name = queue_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}

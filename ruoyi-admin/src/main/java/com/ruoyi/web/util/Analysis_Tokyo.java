package com.ruoyi.web.util;

import com.ruoyi.web.domain.Tokyo_33;
import com.ruoyi.web.domain.Tokyo_46;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HexFormat;

/**
 * @Author : baye
 * @Date : 2023/6/29 10:56
 * @Code : bug and work
 * @Description : 东洋机数据分析工具类
 */
public class Analysis_Tokyo {

    private StringBuilder sb_hex = new StringBuilder();

    private final Logger LOGGER_SC = LoggerFactory.getLogger(Analysis_Tokyo.class);

    //接收数据的时间
    private volatile long rec_time = System.currentTimeMillis();

    private volatile int sumcheck_error_count;

    private static final int time_start = 0;
    private static final int time_stop = 13;
    private static final int code_start = time_stop + 5;
    private static final int code_stop = code_start + 2;

    private static final int content_start = code_stop + 2;



    //队列接收数据时使用的消息过滤方法
    public Tokyo_33 filter(String str_hex) throws Exception {
        Tokyo_33 tokyo_33 = new Tokyo_33();
        long time = Long.parseLong(str_hex.substring(time_start, time_stop));
        String resp_code = str_hex.substring(code_start, code_stop);
//        String resp_code = new String(HexFormat.of().parseHex(str_hex.substring(code_start, code_stop)), StandardCharsets.UTF_8);

        //数据接收时间、时间戳
        tokyo_33.setRecv_unixts((int)time);
        tokyo_33.setRecv_time(DateString.millisecondToDate(time));
        if(resp_code.equals("33")){
            String content_hex = str_hex.substring(content_start, str_hex.length());
//            String content = new String(content_hex, "Shift_JIS");
            String[] d = content_hex.split(",");

            //设备时间
            String dev_time = d[0].trim() + "-" + d[1].trim() + "-" + d[2].trim() + " " + d[3].trim() + ":" + d[4].trim() + ":" + d[5].trim();
            tokyo_33.setDev_time(DateString.stringLongToDate(dev_time));
            //成形计数
            int id_molding = Integer.parseInt(d[6].trim());
            tokyo_33.setId_molding(id_molding);
            //电热
            BigDecimal t_eh1 = new BigDecimal(d[7].trim());
            tokyo_33.setT_eh1(t_eh1);
            BigDecimal t_eh2 = new BigDecimal(d[8].trim());
            tokyo_33.setT_eh2(t_eh2);
            BigDecimal t_eh3 = new BigDecimal(d[9].trim());
            tokyo_33.setT_eh1(t_eh3);
            BigDecimal t_eh4 = new BigDecimal(d[10].trim());
            tokyo_33.setT_eh1(t_eh4);
            BigDecimal t_eh5 = new BigDecimal(d[11].trim());
            tokyo_33.setT_eh1(t_eh5);
            //料斗温度
            BigDecimal t_hopper = new BigDecimal(d[13].trim());
            tokyo_33.setT_hopper(t_hopper);
            //V-P切换位置
            BigDecimal position_vp = new BigDecimal(d[17].trim());
            tokyo_33.setPosition_vp(position_vp);
            //余量位置
            BigDecimal position_margin = new BigDecimal(d[18].trim());
            tokyo_33.setPosition_margin(position_margin);
            //射出位置
            BigDecimal position_shooting = new BigDecimal(d[19].trim());
            tokyo_33.setPosition_shooting(position_shooting);
            //一次压力
            BigDecimal pressure1 = new BigDecimal(d[25].trim());
            tokyo_33.setPressure1(pressure1);
            //二次压力
            BigDecimal pressure2 = new BigDecimal(d[26].trim());
            tokyo_33.setPressure2(pressure2);
            //三次压力
            BigDecimal pressure3 = new BigDecimal(d[27].trim());
            tokyo_33.setPressure3(pressure3);
            //树脂压
            BigDecimal pressure_resin = new BigDecimal(d[31].trim());
            tokyo_33.setPressure_resin(pressure_resin);
            //周期时间
            BigDecimal timing_cycle = new BigDecimal(d[55].trim());
            tokyo_33.setTiming_cycle(timing_cycle);
            //填充时间
            BigDecimal timing_fill = new BigDecimal(d[56].trim());
            tokyo_33.setTiming_fill(timing_fill);
            //计量时间
            BigDecimal timing_metering = new BigDecimal(d[57].trim());
            tokyo_33.setTiming_metering(timing_metering);
            //最大压力
            BigDecimal pressure_max = new BigDecimal(d[66].trim());
            tokyo_33.setPressure_max(pressure_max);
            //最大速度
            BigDecimal speed_max = new BigDecimal(d[67].trim());
            tokyo_33.setSpeed_max(speed_max);
            //原始数据
            byte[] original_data = content_hex.getBytes();
            tokyo_33.setOriginal_data_bin(original_data);
            String original_data_hex = content_hex;
            tokyo_33.setOriginal_data_hex(original_data_hex);

            return tokyo_33;
        }
        else {
            return null;
        }

    }
    public Tokyo_46 filter46(String str_hex) throws Exception {
        Tokyo_46 tokyo_46 = new Tokyo_46();
        long time = Long.parseLong(str_hex.substring(time_start, time_stop));
        String resp_code = str_hex.substring(code_start, code_stop);

        //数据接收时间、时间戳
        tokyo_46.setRecv_unixts((int)time);
        tokyo_46.setRecv_time(DateString.millisecondToDate(time));
        if(resp_code.equals("46")){
            String content_hex = str_hex.substring(content_start, str_hex.length());
//            String content = new String(content_hex, "Shift_JIS");
            String[] d = content_hex.split(",");

            //设备时间
            String dev_time = d[0].trim() + " " + d[1].trim();
            tokyo_46.setDev_time(DateString.stringLongToDate(dev_time));
            //机种名
            String device_type = d[2].trim();
            tokyo_46.setDevice_type(device_type);
            //运转模式编码
            int operating_mode_coding = Integer.parseInt(d[3].trim());
            tokyo_46.setOperating_mode_coding(operating_mode_coding);
            //运转模式名
            String operating_mode = d[4].trim();
            tokyo_46.setOperating_mode(operating_mode);
            //产品名
            String product_name = d[5].trim();
            tokyo_46.setProduct_name(product_name);
            //模号
            String mold_id = d[6].trim();
            tokyo_46.setMold_id(mold_id);
            //模数
            int id_molding = Integer.parseInt(d[7].trim());
            tokyo_46.setId_molding(id_molding);
            //循环时间
            String cycle_time = d[8].trim();
            tokyo_46.setCycle_time(cycle_time);
            //运转时间
            String operating_time = d[9].trim();
            tokyo_46.setOperating_time(operating_time);
            //停止时间
            String stop_time = d[10].trim();
            tokyo_46.setStop_time(stop_time);
            //不良数
            int ng_number = Integer.parseInt(d[11].trim());
            tokyo_46.setNg_number(ng_number);
            //不良率
            BigDecimal ng_rate = new BigDecimal(d[12].trim());
            tokyo_46.setNg_rate(ng_rate);
            //生产数
            int product_number = Integer.parseInt(d[13].trim());
            tokyo_46.setProduct_number(product_number);
            //生产率
            BigDecimal product_rate = new BigDecimal(d[14].trim());
            tokyo_46.setProduct_rate(product_rate);
            //运转率
            BigDecimal operating_rate = new BigDecimal(d[15].trim());
            tokyo_46.setOperating_rate(operating_rate);
            //进展
            BigDecimal evolve = new BigDecimal(d[16].trim());
            tokyo_46.setEvolve(evolve);
            //原始数据
            byte[] original_data = content_hex.getBytes();
            tokyo_46.setOriginal_data_bin(original_data);
            String original_data_hex = content_hex;
            tokyo_46.setOriginal_data_hex(original_data_hex);

            return tokyo_46;
        }

        else {
            return null;
        }

    }

    private static String ts2zdt(String ts) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS Z");
        ZoneId utc8 = ZoneId.of("UTC+8");
        return dateTimeFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(ts)), utc8));
    }

    //判断校验码是否正确,正确就保存
    public boolean check_sum_8bit(StringBuilder sb, int c1, int c2, int c3) {
        try {
            String s = sb.substring(c1, c2);
            if ((s.length() & 1) != 0) {
//            System.out.println("S: " + sb);
                LOGGER_SC.debug("数据长度非偶 :" + s);
            }
            byte[] text = HexFormat.of().parseHex(s);
            String sum1 = String.valueOf((char) Integer.parseInt(sb.substring(c3 - 4, c3 - 2), 16));
            String sum2 = String.valueOf((char) Integer.parseInt(sb.substring(c3 - 2, c3), 16));
            int res = 0;
            for (byte i : text) {
                res += i;
            }
            res = res & 0xFF;
//        System.out.println("res "+Integer.toHexString(res).toUpperCase());
            return res == Integer.parseInt(sum1 + sum2, 16);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] saveResp(StringBuilder sb_hex, int resp_head_index, int resp_tail_index, Long currenttime) {
           byte[] b = byteMerger(String.valueOf(currenttime).getBytes(),
                    HexFormat.of().parseHex("0D"),
                    HexFormat.of().parseHex(sb_hex.substring(resp_head_index, resp_tail_index)));
           return b;
    }

    public byte[] byteMerger(byte[] bt1, byte[] bt2, byte[] bt3) {
//        byte[] bt = new byte[bt1.length + bt2.length + bt3.length + bt4.length + bt5.length];
        byte[] bt = new byte[bt1.length + bt2.length + bt3.length];
        System.arraycopy(bt1, 0, bt, 0, bt1.length);
        System.arraycopy(bt2, 0, bt, bt1.length, bt2.length);
        System.arraycopy(bt3, 0, bt, bt1.length + bt2.length, bt3.length);
//        System.arraycopy(bt4, 0, bt, bt1.length + bt2.length + bt3.length, bt4.length);
//        System.arraycopy(bt5, 0, bt, bt1.length + bt2.length + bt3.length + bt4.length, bt5.length);
        return bt;
    }



}

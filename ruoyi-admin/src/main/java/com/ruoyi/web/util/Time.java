package com.ruoyi.web.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : baye
 * @Date : 2023/6/7 10:47
 * @Code : bug and work
 * @Description : 时间工具
 */
public class Time {

    //返回时间更前的时间段
    public static String TimeCompare(String date1,String date2) throws Exception {
        Date date1_1 = DateString.stringLongToDate(date1);
        Date date2_1 = DateString.stringLongToDate(date2);
        if(date1_1.compareTo(date2_1) < 0){
            return date1;
        }else{
            return date2;
        }

    }
    //判断时间先后
    public static int TimeCompare2(String date1,String date2) throws Exception {
        Date date1_1 = DateString.stringLongToDate(date1);
        Date date2_1 = DateString.stringLongToDate(date2);
        return date1_1.compareTo(date2_1);

    }
    //判断时间差
    public static String CalTime(String time1,String time2)throws Exception{
        Date date1 = DateString.stringLongToDate(time1);//开始时间
        Date date2 = DateString.stringLongToDate(time2);//结束 || 当前时间
        long diff = date2.getTime() - date1.getTime();

        Long mymint = diff/1000/60;
        int intValue = mymint.intValue();
        BigDecimal b = new BigDecimal((double)intValue/60);
        Double hour = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();//第一个参数是保留小数的位数
        return String.valueOf(hour);

    }

}

package com.stylefeng.guns.modular.dist.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    public static void main(String[] args) {
        System.out.println(DateUtils.getNowDateTime());
    }
    public static String longToDateAll(Long time) {
        return getDateParser("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }

    public static String getNowDateTime(){
        return LocalDateTime.now().toString().replaceAll("T"," ").substring(0,19);
    }

    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }


    /**
     * 当前日期加上天数后的日期
     * @param num 为增加的天数
     * @return
     */
    public static String plusDay(int num){
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currdate = format.format(d);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        return enddate;
    }
}

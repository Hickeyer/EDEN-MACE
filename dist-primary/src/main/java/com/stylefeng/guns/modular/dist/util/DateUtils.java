package com.stylefeng.guns.modular.dist.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    public static void main(String[] args) {
        System.out.println(getFirstMountDay(1));
        System.out.println(getLastMountDay(1));
    }
    public static String longToDateAll(Long time) {
        return getDateParser("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }

    public static String preNowDate(){
        return LocalDateTime.now().toString().substring(0,10);
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
        Calendar ca = Calendar.getInstance();
        // num为增加的天数，可以改变的
        ca.add(Calendar.DATE, num);
        d = ca.getTime();
        String enddate = format.format(d);
        return enddate;



    }


    public static String getLastMountDay(int num){
        Calendar ca = Calendar.getInstance();
        // num为增加的天数，可以改变的
        ca.add(Calendar.MONTH, num);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));

        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        d =ca.getTime();
        return  format.format(d);
    }
    public static String getFirstMountDay(int num){
        Calendar ca = Calendar.getInstance();
        // num为增加的天数，可以改变的
        ca.add(Calendar.MONTH, num);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMinimum(Calendar.DAY_OF_MONTH));

        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        d =ca.getTime();
        return  format.format(d);
    }

    public static  Date getNextYear(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.YEAR,1);
        return ca.getTime();
    }

}

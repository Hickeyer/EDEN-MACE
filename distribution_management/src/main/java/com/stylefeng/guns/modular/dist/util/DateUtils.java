package com.stylefeng.guns.modular.dist.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String longToDateAll(Long time) {
        return getDateParser("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }


    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }
}

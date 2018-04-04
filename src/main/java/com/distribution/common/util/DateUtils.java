package com.distribution.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangpu on 2017/6/3.
 */
public class DateUtils {

    public static String longToDateAll(Long time) {
        return getDateParser("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }


    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }

}

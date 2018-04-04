package com.distribution.common.util;

/**
 * Created by huangpu on 2017/6/3.
 */
public class Page {

    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
}

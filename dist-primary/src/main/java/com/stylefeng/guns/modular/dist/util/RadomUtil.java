package com.stylefeng.guns.modular.dist.util;

import java.util.Random;

public class RadomUtil {

    public static String getRandomSalt(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABDCDEFGHIJKLMN0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}

package com.stylefeng.guns.modular.dist.util;

/**
 * @ClassName DistUtils
 * @autor huangpu
 * @DATE 2019/5/18
 **/
public class DistUtils {

    /**
     * 反转数组
     * @param array
     * @return
     */
    public static String[] reverseArray(String[] array){
        String [] newArray = new String[array.length];
        for(int i=0; i<newArray.length; i++){
            newArray[i] = array[array.length - i - 1];
        }
        return newArray;
    }
}

    
    
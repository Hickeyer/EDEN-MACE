package com.stylefeng.guns.common.annotion.log;

import java.lang.annotation.*;

/**
 * socket注册监听
 */
@Inherited
@Target({ElementType.METHOD})
public @interface StatisticsSocket {

    //默认值，目前无意义
    String value() default "";

}

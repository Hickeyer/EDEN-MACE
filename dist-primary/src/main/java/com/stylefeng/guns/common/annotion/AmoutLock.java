package com.stylefeng.guns.common.annotion;

import java.lang.annotation.*;

/**
 * @ClassName AmoutLock
 * @autor huangpu
 * @DATE 2019/9/25
 **/
@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AmoutLock {


    //默认值，目前无意义
    String value() default "";
}

    
    
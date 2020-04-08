package com.stylefeng.guns.common.annotion;

import java.lang.annotation.*;

/**
 * @ClassName OpenApiEncrypt
 * @Description 对Open Api 请求数据加密
 * 但是app端的数据需要自己加密，可以提供对应的加密工具类
 * @Author zj
 * @Date 2020/4/8 13:06
 * @Company
 **/

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenApiEncrypt {
    String name() default "DES";
}

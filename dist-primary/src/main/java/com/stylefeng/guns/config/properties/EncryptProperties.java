package com.stylefeng.guns.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName EncryptProperties
 * @Description 加密属性文件
 * @Author zj
 * @Date 2020/4/8 13:36
 * @Company
 **/
@Component
@ConfigurationProperties(prefix = "encrypt")
public class EncryptProperties {

    private String name;

    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

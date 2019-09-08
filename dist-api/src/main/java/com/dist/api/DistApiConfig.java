package com.dist.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DistApiConfig
 * @autor huangpu
 * @DATE 2019/9/7
 **/
@Configuration
public class DistApiConfig {

    @Bean
    public SendToDistService sendToDistService(){
        return new SendToDistService();
    }
}

    
    
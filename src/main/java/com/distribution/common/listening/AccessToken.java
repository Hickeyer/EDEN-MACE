package com.distribution.common.listening;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by huangpu on 2017/4/13.
 */
@Component
public class AccessToken {
    /**
     * 获取tis平台token
     */
    @Scheduled(fixedDelay = 1000*60)
    public  void  refreshFYKJToken(){
    ;
    }
}



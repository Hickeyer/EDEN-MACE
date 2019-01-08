package com.stylefeng.guns.core.aop;

import com.stylefeng.guns.common.annotion.log.StatisticsSocket;
import com.stylefeng.guns.config.StatisticsWebSocket;
import com.stylefeng.guns.modular.dist.service.IStatisticsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author  xiaojiang
 * 触发socket切面
 */
@Aspect
@Component
public class StatisticsSocketAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    StatisticsWebSocket statisticsWebSocket;

    @Autowired
    IStatisticsService statisticsService;

    @Pointcut(value = "@annotation(com.stylefeng.guns.common.annotion.log.StatisticsSocket)")
    public void cutService() {

    }

    @AfterReturning("cutService()")
    public void AfterReturning(JoinPoint point){
        log.info("开始发送消息");
        String msg = statisticsService.findStatisticsInfo();
        statisticsWebSocket.sendMessage(msg);
        log.info("发送消息结束");
    }

}

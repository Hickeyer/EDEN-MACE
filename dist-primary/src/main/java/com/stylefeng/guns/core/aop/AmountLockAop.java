package com.stylefeng.guns.core.aop;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AmountLockAop
 * @autor huangpu
 * @DATE 2019/9/25
 *  金额锁
 **/
@Aspect
@Component
public class AmountLockAop {


    private Logger log = LoggerFactory.getLogger(this.getClass());


    private static  String switchTag;

    private static String connectString;

    private static CuratorFramework curatorFramework = null;



    @Pointcut(value = "@annotation(com.stylefeng.guns.common.annotion.AmoutLock)")
    public void cutService() {
    }

    public void initFramework(){
        if(curatorFramework!=null){
            return ;
        }
        Properties properties = new Properties();
        InputStream in = AmountLockAop.class.getClass().getResourceAsStream("/config/zookeeper.properties");
        if(in==null){return;};
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        switchTag = properties.getProperty("zk.switch");
        connectString = properties.getProperty("zk.connectString");
        if("true".equals(switchTag)){
            curatorFramework =
                    CuratorFrameworkFactory.builder()
                            .connectString(connectString)
                            .retryPolicy(new ExponentialBackoffRetry(1000,3))
                            .build();
            curatorFramework.start();

        }
    }

    /**
     * 获取第一个参数加锁
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("cutService()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        initFramework();
        Object[] args = point.getArgs();
        if(args!=null&&args.length>0&&curatorFramework!=null){

            String path = "/amount/"+args[0];
            final InterProcessMutex lock = new InterProcessMutex(curatorFramework,path);
            try {
                log.info("金额开始锁表{}",path);
                lock.acquire();
                return point.proceed();
            }finally {
                lock.release();
                log.info("金额锁表完成{}",path);
            }

        }

        return point.proceed();
    }
}

    
    
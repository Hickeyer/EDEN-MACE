package com.plug.xiaojiang.dist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DistMemberAop {

    @Pointcut(value = "@annotation(com.plug.xiaojiang.dist.annotation.DistMember)")
    public void cut() {
    }

    @Around("cut()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        try {
            handle(point);
        } catch (Exception e) {
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception{
        Object[] args= point.getArgs();

        String className = point.getTarget().getClass().getName();
    }

}

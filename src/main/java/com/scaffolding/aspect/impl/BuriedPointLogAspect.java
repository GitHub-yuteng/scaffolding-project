package com.scaffolding.aspect.impl;

import com.whhim.hxh.util.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author whh-yt
 */
@Component
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BuriedPointLogAspect {

    @Pointcut("@annotation(com.whhim.hxh.aspect.BuriedPointLog)")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtils.DATE_TIME)));
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //执行方法 埋点
        return joinPoint.proceed();
    }
}
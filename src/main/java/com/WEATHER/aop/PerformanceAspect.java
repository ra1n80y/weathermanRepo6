package com.WEATHER.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect
{
    private static final Logger logger= LoggerFactory.getLogger (PerformanceAspect.class);

    @Around ("execution(* com.WEATHER.service.TouristImpl.fetchAllTourists(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable
    {
        //@Around logs method's activity DURING its execution
        //ProceedingJoinPoint's proceed() returns Object, hence the return type of this method
        long start=System.currentTimeMillis ();
        Object obj=jp.proceed ();
        long end=System.currentTimeMillis ();

        logger.info ("Time taken: {}", (end-start));

        return obj;
    }
}

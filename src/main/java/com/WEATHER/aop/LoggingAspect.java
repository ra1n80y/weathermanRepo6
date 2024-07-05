package com.WEATHER.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    //SL4J Logger obj
    private static final Logger logger= LoggerFactory.getLogger (LoggingAspect.class);

    //Annotation syntax: returnType, className.methodName(args)
    @Before ("execution(* com.WEATHER.service.TouristImpl.fetchAllTourists(..))")
    public void logMethodCall(JoinPoint jp)//JoinPoint specifies method invocation details
    {
        //"||" can be used to add another JP if need be
        logger.info ("Method called {} ", jp.getSignature ());
    }

    @After ("execution(* com.WEATHER.service.TouristImpl.fetchAllTourists(..))")
    public void logMethodExecution()
    {
        logger.info ("Method Executed");
    }
}

package com.example.springbootrest.SpringBootRest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {


    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);


    @Around("execution(* com.example.springbootrest.SpringBootRest.service.JobService.returnAllJobPosts(..))")
    public Object performanceMonitorAdvice1(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object obj= joinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken : " + (end - start));
        return  obj;
    }
}

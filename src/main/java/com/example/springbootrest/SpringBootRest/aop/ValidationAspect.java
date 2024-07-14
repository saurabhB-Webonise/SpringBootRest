package com.example.springbootrest.SpringBootRest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {


    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.example.springbootrest.SpringBootRest.service.JobService.getJobById(..)) && args(postId)")
    public Object validate(ProceedingJoinPoint joinPoint, int postId) throws Throwable {

        if (postId < 0) {
            LOGGER.info("PostId is Negative, updating it...");
            postId = -postId;
            LOGGER.info("New Values : " + postId);
        }
        return joinPoint.proceed(new Object[]{postId});
    }

}

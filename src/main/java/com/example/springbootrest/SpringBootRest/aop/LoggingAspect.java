package com.example.springbootrest.SpringBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect  {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution(* com.example.springbootrest.SpringBootRest.service.JobService.*(..))")
    public void logMethodCallAdvice1(JoinPoint joinPoint) {
        // this method is a advice
        LOGGER.info(joinPoint.getSignature().getName() + " Method Before Executing");
    }


    @Before("execution(* com.example.springbootrest.SpringBootRest.service.JobService.returnAllJobPosts(..))")
    public void logMethodCallAdvice2(JoinPoint joinPoint) {
        // this method is a advice
        LOGGER.info(joinPoint.getSignature().getName() + " Method Before Executing. This Advice only called for returnAllJobPosts");
    }


    @Before("execution(* com.example.springbootrest.SpringBootRest.service.JobService.returnAllJobPosts(..)) || execution(* com.example.springbootrest.SpringBootRest.service.JobService.deleteJob(..))")
    public void logMethodCallAdvice3(JoinPoint joinPoint) {
        // this method is a advice
        LOGGER.info(joinPoint.getSignature().getName() + " Method Before Executing. This Advice only called for returnAllJobPosts and deleteJob");
    }


    @After("execution(* com.example.springbootrest.SpringBootRest.service.JobService.*(..))")
    public void logMethodCallAdvice4(JoinPoint joinPoint) {
        // this method is a advice
        LOGGER.info(joinPoint.getSignature().getName() + " Method Executed (After)");
    }


    @AfterThrowing("execution(* com.example.springbootrest.SpringBootRest.service.JobService.*(..))")
    public void logMethodCallAdvice5(JoinPoint joinPoint) {
        // this method is a advice
        LOGGER.info(joinPoint.getSignature().getName() + " Method Throwing Error (AfterThrowing)");
    }

    @AfterReturning("execution(* com.example.springbootrest.SpringBootRest.service.JobService.*(..))")
    public void logMethodCallAdvice6(JoinPoint joinPoint) {
        // this method is a advice
        LOGGER.info(joinPoint.getSignature().getName() + " Method Returning  (AfterReturning)");
    }

}

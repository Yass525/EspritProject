package com.example.demo.config;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
//    private static final Logger l = (Logger) LogManager.getLogger(LoggingAspect.class);
//    @Before("execution(* com.example.demo.service.StockService.*(..))")
//            public void logMethodEntry(JoinPoint joinPoint){
//                String name=joinPoint.getSignature().getName();
//                l.info("in method"+":");
//    }
//
//    @After("execution(* com.example.demo.service.StockService.*(..))")
//    public void logMethodExit(JoinPoint joinPoint) {
//        String name=joinPoint.getSignature().getName();
//        l.info("in method"+":");
//    }
//    @Around("execution(* com.example.demo.service.StockService.*.*(..))")
//     public Object profile(ProceedingJoinPoint pjp) throws Throwable{
//        long start = System.currentTimeMillis();
//        Object obj = pjp.proceed();
//        long elapsedTime = System.currentTimeMillis() - start;
//        l.info("Method execution time: " + elapsedTime + " milliseconds.");
//        return obj;
//    }
}
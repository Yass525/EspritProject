package com.exemple.demo.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	//private static final Logger LOGGER = LoggerFactory.getLogger("com.example.demo.config.LoggingAspect");

     
   /** @Around("execution(* com.example.demo.service.StockService..*.* (..))")
    public Object logBeforeAndAfterServiceMethods(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("{} has started execution.", pjp.getSignature());
        Object resultOfMethodCall = pjp.proceed();
        LOGGER.info("{} finished execution", pjp.getSignature());
        return resultOfMethodCall;
    }*/
	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
	@Before("execution(* com.example.demo.services.StockService.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	logger.info("In method " + name + " : ");
	}
	@After("execution(* com.example.demo.services.StockService.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		logger.info("In method " + name + " : ");
		}
	@Around("execution(*com.example.demo.services.*.*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	    long start = System.currentTimeMillis();

	    Object proceed = joinPoint.proceed();

	    long executionTime = System.currentTimeMillis() - start;

	    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    return proceed;
	}
}

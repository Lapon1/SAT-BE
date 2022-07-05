package com.lapon.app.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogSaveAspect {
	private Long startTime;
	private final Logger logger = LogManager.getLogger(LogSaveAspect.class);

	@Before("execution(* com.lapon.app.controller..*Controller.*(..))")
	public void beforeController(JoinPoint joinPoint) throws Throwable {
		logger.info("begin process {}", joinPoint.getSignature().toShortString());
		startTime = System.nanoTime();
	}

	@AfterReturning(pointcut = "execution(* com.lapon.app.controller..*Controller.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) throws Throwable {
		logger.info("end process {} with {} ms execution time", joinPoint.getSignature().toShortString(), getTimeUsed());
	}

	private Long getTimeUsed() {
		return ((System.nanoTime() - startTime) / 1000000);
	}
}
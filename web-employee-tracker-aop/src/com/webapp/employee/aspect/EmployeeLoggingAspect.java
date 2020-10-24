package com.webapp.employee.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeLoggingAspect {

	//setup logger
	private Logger log = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	
	//for controller package
	@Pointcut("execution(* com.webapp.employee.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//for service package
	@Pointcut("execution(* com.webapp.employee.service.*.*(..))")
	private void forServicePackage() {}
		
	//for DAO package
	@Pointcut("execution(* com.webapp.employee.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		log.info("==> in @Before: calling method: " + method);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object temp : args) {
			
			log.info("==>Arguments: " + temp);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",
					returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		log.info("==> in @AfterReturning: from method: " + method);
		
		log.info("==>Result: " + result);
		
	}
}
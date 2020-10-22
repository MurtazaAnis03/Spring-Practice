package com.demo5.spring.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo5.spring.aop.Account;
import com.demo5.spring.aop.AroundDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());

	//here we add all our related advises for logging
	
	//starting with @Before advice
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void com.demo5.spring.aop.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(void add*())")
	//@Before("execution(* add*())")
	//@Before("execution(* add*(com.demo5.spring.aop.Account))")		//will match add() having type of Account object as parameter
	//@Before("execution(* add*(com.demo5.spring.aop.Account, ..))")	//Account object + any no. of args
	//@Before("execution(* add*(..))")
	//@Before("execution(* com.demo5.spring.aop.dao.*.*(..))")
	
	//@Before("forDaoPackage()")
	
	//@Before("com.demo5.spring.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	
	//add a new advice for @AfterReturning advice accounts method
	@AfterReturning(pointcut="execution(* com.demo5.spring.aop.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("==> Executing @AfterReturning advice on method: " + method);
		myLogger.info("==> Result: " + result);
		
		//post-process the data
		
		//convert account names to uppercase
		convertAccountNamesToUpperCase(result);
		myLogger.info("==> Result: " + result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		//loop thru accounts
		for(Account temp : result) {
		
			//get uppercase version of name
			String upperName = temp.getName().toUpperCase();
		
			//update the name of the account
			temp.setName(upperName);
		}
	}


	public void afterAddAccountAdvice(JoinPoint joinPoint) {
		myLogger.info("==> Executing @After advice on method");
		
		//display method signature
		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Method Signature: " + methodSign);
		
		//display method args
		//get args
		Object[] args = joinPoint.getArgs();
		
		//loop thru args
		for(Object temp : args) {
			myLogger.info((String) temp);
			
			if(temp instanceof Account) {
				
				Account account = (Account) temp;
				
				myLogger.info("Account name: " + account.getName());
				myLogger.info("Account level: " + account.getLevel());
			}
		}
		
	}
	//Add @AfterThrowing advice
	@AfterThrowing(pointcut="execution(* com.demo5.spring.aop.dao.AccountDAO.findAccounts(..))",
					throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		//display method signature
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("==> Executing @AfterThrowing advice on method: " + method);
		
		//log the Exception
		myLogger.info("The Exception: " + theExc);
	}
	
	@After("execution(* com.demo5.spring.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		
		//display method signature
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("==> Executing @After(finally) advice on method: " + method);
		
	}
	
	//Working with @Around
	@Around("execution(* com.demo5.spring.aop.service.*.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("==> Executing @Around advice on method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			
			result = proceedingJoinPoint.proceed();
		} 
		catch (Exception e) {
			
			myLogger.warning(e.getMessage());
			
			//result = "Major accident! But no worries";
			
			//rethrow exception
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		myLogger.info("--->Duration: " + duration / 1000.0 + " secs");
		
		return result;
		
	}
	
}
package com.demo5.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	//Pointcut for Package
		@Pointcut("execution(* com.demo5.spring.aop.dao.*.*(..))")
		public void forDaoPackage() {}
		
		//Pointcut for Getters
		@Pointcut("execution(* com.demo5.spring.aop.dao.*.get*(..))")
		public void getter() {}
		
		//Pointcut for Setters
		@Pointcut("execution(* com.demo5.spring.aop.dao.*.set*(..))")
		public void setter() {}
		
		//Pointcut : include package and exclude Getters-Setters
		@Pointcut("forDaoPackage() && !( getter() || setter())")
		public void forDaoPackageNoGetterSetter() {}
}
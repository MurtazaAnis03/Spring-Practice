package com.demo5.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {

	//@Before("forDaoPackage()")
		@Before("com.demo5.spring.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
		public void performApiAnalytics() {
			
			System.out.println("==> Performing API Analytics");
		}
		
}
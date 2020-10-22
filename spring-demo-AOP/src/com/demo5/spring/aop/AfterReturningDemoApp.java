package com.demo5.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo5.spring.aop.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
	
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		//display accounts
		System.out.println("\nMain Program: AfterReturningDemoApp \n -------------");
		System.out.println(theAccounts);
		
		//close the context
		context.close();
	}

}
package com.demo5.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo5.spring.aop.dao.AccountDAO;
import com.demo5.spring.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
	
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		myAccount.setName("Dan");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.isWorking();
		
		theAccountDAO.setName("John");
		theAccountDAO.setServiceCode("Writer");
		
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		//call the business method
		theMembershipDAO.addMembership();
		theMembershipDAO.doSomeWork();
		
		//close the context
		context.close();
	}

}
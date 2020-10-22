package com.demo5.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMembership() {
		
		System.out.println(getClass() + " : Adding a membership account \n");
		
		return true;
	}
	
	public void doSomeWork() {
		
		System.out.println(getClass() + " : doSomeWork() \n");
	}
	
}
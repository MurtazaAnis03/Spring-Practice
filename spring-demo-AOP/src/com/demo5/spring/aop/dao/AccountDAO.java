package com.demo5.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo5.spring.aop.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("Exception throw");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Maria", "Gold");
		Account temp3 = new Account("Lisa", "Platinum");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + " : Adding an account \n");
	}
	
	public boolean isWorking() {
		System.out.println(getClass() + " : isWorking() \n");
		
		return false;
	}

	public String getName() {
		System.out.println(getClass() + " : getName() \n");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : setName() \n");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : getServiceCode() \n");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : setServiceCode() \n");
		this.serviceCode = serviceCode;
	}
	
	
}
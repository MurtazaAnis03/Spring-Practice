package com.Demo4.hibernate.entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3308/hb_student_tracker?useSSL=false & serverTimeZone=UTC";
		String user = "hbstudent";
		String pwd = "hbstudent";
		
		try {
			System.out.println("Conn to db: "+url);
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Conn success");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

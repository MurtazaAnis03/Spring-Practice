package com.Demo2.SpringPractice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		//Coach coach = context.getBean("myTennisCoach", Coach.class);
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		//call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		System.out.println("Email: "+coach.getEmail());
		System.out.println("Team: "+coach.getTeam());
		
		//close the context
		context.close();
	}

}
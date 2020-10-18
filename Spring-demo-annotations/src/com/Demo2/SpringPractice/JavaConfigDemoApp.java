package com.Demo2.SpringPractice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		//Coach coach = context.getBean("myTennisCoach", Coach.class);
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
package com.Demo2.SpringPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

// @Component("myTennisCoach")	//explicitly specifying bean ID
@Component	//default bean ID will be tennisCoach

//@Scope("prototype")

public class TennisCoach implements Coach {

	//define my init method
//	@PostConstruct
	public void myStartupStuff() {
		System.out.println("TennisCoach: inside of myStartupStuff()");
	}
	
//	@PreDestroy
	public void myCleanupStuff() {
		System.out.println("TennisCoach: inside of myCleanupStuff()");
	}
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}
	
	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	//define a setter method
/*	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("TennisCoach: inside setFortuneService()");
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
package com.Demo1.SpringPractice;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAdd;
	private String team;
	
	//create a no-arg constructor
	public CricketCoach() {
		System.out.println("inside no-arg CricketCoach constructor");
	}
	
	//setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("inside CricketCoach setFortuneService setter method");
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
		System.out.println("inside CricketCoach setEmailAdd setter method");
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("inside CricketCoach setTeam setter method");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
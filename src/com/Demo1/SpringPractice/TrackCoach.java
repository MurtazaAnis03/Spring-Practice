package com.Demo1.SpringPractice;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	//create a no-arg constructor
	public TrackCoach() {
		
	}
		
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard of 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: "+fortuneService.getFortune();
	}
	
	//add an init method
	public void myStartupStuff() {
		System.out.println("TrackCoach: inside method myStartupStuff");
	}
	
	//add an destroy method
	public void myCleanupStuff() {
		System.out.println("TrackCoach: inside method myCleanupStuff");
	}
}
package com.Demo2.SpringPractice;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] data = {
			"String 1",
			"String 2",
			"String 3"
	};
	
	//create  a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String myFortune = data[index];
		return myFortune;
	}

}
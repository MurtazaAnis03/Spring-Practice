package com.demo8.springboot.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	
	//expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello World! Time on server is " +LocalDateTime.now();
	}
	
	//expose endpoint for "teaminfo"
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		
		return "Coach: " + coachName + ", Team Name: " + teamName;
	}
}
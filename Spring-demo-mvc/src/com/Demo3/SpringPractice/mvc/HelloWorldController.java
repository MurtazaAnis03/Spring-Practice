package com.Demo3.SpringPractice.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller() to initial HTML Form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller() to process the HTML Form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//create new controller() to read form data
	
	@RequestMapping("/processFormV2")
	public String letsShout(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML form
		String name = request.getParameter("studentName");
		
		//convert the data to all caps
		name = name.toUpperCase();
		
		//create the message
		String result  = "Yo! " + name;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormV3")
	public String processFormV3(
			@RequestParam("studentName") String name, 
			Model model) {
		
		//convert the data to all caps
		name = name.toUpperCase();
		
		//create the message
		String result  = "Heyy! " + name;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
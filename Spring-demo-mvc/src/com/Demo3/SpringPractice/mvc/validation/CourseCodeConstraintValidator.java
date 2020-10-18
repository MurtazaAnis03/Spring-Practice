package com.Demo3.SpringPractice.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode courseCode) {
		
		coursePrefixes = courseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

		boolean result = false;
		
		if(theCode != null) {
			//result = theCode.startsWith(coursePrefix);
			
			//for multiple validating string in one annotation 
			for (String tempPrefix : coursePrefixes) {
                result = theCode.startsWith(tempPrefix);
                
                // if we found a match then break out of the loop
                if (result) {
                    break;
                }
            }
		}
		else {
			return true;
		}
		return result;
	}

}
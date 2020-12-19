package com.user.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
	public static boolean email_validation(String email) {
		boolean status = false;
		
		String pattern1 = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{1,3}$";
		
		Pattern pattern = Pattern.compile(pattern1);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()) {
			status = true;
			
		}
		else {
			status = false;
		}
		return status;
	}

}

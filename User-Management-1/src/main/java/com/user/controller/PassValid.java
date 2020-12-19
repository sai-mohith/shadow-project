package com.user.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassValid {
	public static boolean Pass_validation(String password) {
		boolean status = false;
		
		String pattern1 = "^[a-zA-Z0-9]{1,20}[@,#,$,%,^,&,*][a-zA-Z0-9]{1,20}$";
		
		Pattern pattern = Pattern.compile(pattern1);
		Matcher matcher = pattern.matcher(password);
		if(matcher.matches()) {
			status = true;
			
		}
		else {
			status = false;
		}
		return status;
	}


}

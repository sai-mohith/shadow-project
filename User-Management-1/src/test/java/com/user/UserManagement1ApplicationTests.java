package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.controller.Registration;

//@SpringBootTest
class UserManagement1ApplicationTests {
	
	@Test
	void Firstname() {
		Registration obj=new Registration();
        int output=obj.name("prakash");
        assertEquals(1,output);
        int output1=obj.name("");
        assertEquals(0,output1);
        int output2 = obj.name("mohith");
        assertEquals(1,output2);
	}
	@Test
	void email() {
		Registration obj = new Registration();
		int output= obj.mail("mohith@gmail.com");
		assertEquals(1,output);
		int output1= obj.mail("mohith");
		assertEquals(0,output1);
		int output2= obj.mail("mohith123@gmail.com");
		assertEquals(1,output2);
		int output3= obj.mail("");
		assertEquals(0,output1);
		
		
	}
	@Test
	void pincode() {
		Registration obj=new Registration();
        int output=obj.pincode("123456");
        assertEquals(1,output);
        int output1=obj.pincode("");
        assertEquals(0,output1);
        int output2 = obj.pincode("1234567");
        assertEquals(0,output2);
	}
	@Test
	void phone() {
		Registration obj=new Registration();
        int output=obj.name("1234567890");
        assertEquals(1,output);
        int output1=obj.name("");
        assertEquals(0,output1);
        int output2 = obj.name("12345678911");
        assertEquals(1,output2);
	}

}

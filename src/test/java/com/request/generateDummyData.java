package com.request;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class generateDummyData {
	
	@Test
	void testDummyData() {
		Faker faker = new Faker(); 
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String userName = faker.name().username();
		String password = faker.internet().password();
		String mobileNumber = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		
		System.out.println("fullName:"+fullName);
		System.out.println("firstName:"+firstName);
		System.out.println("lastName:"+lastName);
		System.out.println("userName:"+userName);
		System.out.println("password:"+password);
		System.out.println("mobileNumber:"+mobileNumber);
		System.out.println("email:"+email);
	}

}

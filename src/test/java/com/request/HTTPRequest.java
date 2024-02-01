package com.request;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;
//import static io.restassured.RestAssured.*;

import java.util.HashMap;


import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;




public class HTTPRequest {

	int id;

	@Test
	void getStudents() {
		given()
		
		.when()
		.get("http://localhost:3000/Students")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	void createStudent() {
		
		HashMap data = new HashMap();
		data.put("name", "Shivam");
		data.put("location", "India");
		data.put("phone", "99409940");
		String[] courses = {"Maths","Science"};
		data.put("course", courses);
		
		
		
		id = given()
				
				.contentType("application/json")
				.body(data)
		
		.when()
		.post("http://localhost:3000/Students")
		.jsonPath().getInt("id"); //Capturing id from the new student created.
		
		
		.then()
		.statusCode(201)
			.log().all();
		
	}
	
	@Test
	void updateStudent() {
		HashMap data = new HashMap();
		data.put("name", "Shivam");
		data.put("location", "Pakistan");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("http://localhost:3000/Students/"+id)
		
		.then()
			.statusCode(200)
				.log().all();
		}
	
	@Test
	void deleteUser() {
		
		given()
		
		.when()
		
		.delete("http://localhost:3000/Students/"+id)
		
		
		.then()
		.statusCode(204)
		.log().all();
	}
	
	
}

package com.request;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;
//import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


//Different ways are:
//HashMap
//prg.JSON
//POJO class
//External File

public class differentWaysofPostRequest {
	
	//Using HashMap
	@Test
	void postUsingHashMap() {
		HashMap data = new HashMap();
		
		data.put("name", "Ravi");
		data.put("location", "India");
		data.put("phone", "90359035");
		String[] courses = {"C","C++"};
		data.put("course", courses);
		
		
		given()
		.contentType("application/JSON")
		.body(data)
		
		
		.when()
		.post("http://localhost:3000/Students")
		
		.then()
		.statusCode(201)
		//.body("name", equals("Ravi"))
		//.body("location", equals("India"))
		//.body("phone", equals("90359035"))
		//.body("courses[0]",equals("C"))
		//.body("courses[1]",equals("C++"))
		.header("content-type","application/json; charset= utf-8")
		.log().all();
		
		
	}
	
	// Using org.JSON Library
	@Test
	void postUsingJsonLibrary() {
		JSONObject data = new JSONObject();
		
		data.put("name", "Ravi");
		data.put("location", "India");
		data.put("phone", "90359035");
		String[] courses = {"C","C++"};
		data.put("course", courses);
		
		
		given()
		.contentType("application/JSON")
		.body(data.toString())
		
		
		.when()
		.post("http://localhost:3000/Students")
		
		.then()
		.statusCode(201)
		//.body("name", equals("Ravi"))
		//.body("location", equals("India"))
		//.body("phone", equals("90359035"))
		//.body("courses[0]",equals("C"))
		//.body("courses[1]",equals("C++"))
		.header("content-type","application/json; charset= utf-8")
		.log().all();
	
	}
	
	//Using POJO class
	@Test
	void postUsingPOJOClass() {
		POJO_postReq data = new POJO_postReq();
		data.setName("Rahul");
		data.setLocation("India");
		data.setPhone("9431094310");
		String[] courses = {"C","C++"};
		data.setCourse(courses);
		
		
		
		given()
		.contentType("application/JSON")
		.body(data)
		
		
		.when()
		.post("http://localhost:3000/Students")
		
		.then()
		.statusCode(201)
		//.body("name", equals("Ravi"))
		//.body("location", equals("India"))
		//.body("phone", equals("90359035"))
		//.body("courses[0]",equals("C"))
		//.body("courses[1]",equals("C++"))
		.header("content-type","application/json; charset= utf-8")
		.log().all();
	
	}
	
	//Using External JSON class
		@Test
		void postUsingExternalJSONFile() throws FileNotFoundException {
			File fis = new File(".//body.json");
			FileReader fr = new FileReader(fis);
			JSONTokener jt = new JSONTokener(fr);
			JSONObject data = new JSONObject(jt);
			
			
			given()
			.contentType("application/JSON")
			.body(data.toString())
			
			
			.when()
			.post("http://localhost:3000/Students")
			
			.then()
			.statusCode(201)
			//.body("name", equals("Ravi"))
			//.body("location", equals("India"))
			//.body("phone", equals("90359035"))
			//.body("courses[0]",equals("C"))
			//.body("courses[1]",equals("C++"))
			.header("content-type","application/json; charset= utf-8")
			.log().all();
		
		}
}

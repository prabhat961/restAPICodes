package com.request;
//import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class loggingDemo {
	@Test
	
	void testLogs() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		//print entire response
		.log().all()
		
		//print only response body
		.log().body()
		
		//print only cookies
		.log().cookies()
		
		//print only headers
		.log().headers();
	}

}

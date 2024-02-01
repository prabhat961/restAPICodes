package com.request;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;
import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;

//https://reqres.in/api/users?page=2&id=5

public class pathAndqueryParams {

	@Test
	void testQueryandPathparams() {
		
		given()
		.pathParam("myPath", "users")
		.queryParam("page", 2)
		.queryParam("id", 5)
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
}

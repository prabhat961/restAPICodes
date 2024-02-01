package com.request;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class parsingJSONResponseData {
@Test
void testJSONResponse() {
	//Approach 1:
	
	given()
	.contentType(ContentType.JSON)
	
	
	.when()
	.get("http://localhost:3000/Students")
	
	
	.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.body("x[4].phone",equals("9304340159"));
		
	}

//Approach 2:

	@Test
void testentireJSONResponseData() {
	
	Response res = given()
	.contentType(ContentType.JSON)
	
	
	.when()
	.get("http://localhost:3000/Students");
	
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	
	String StudentName = res.jsonPath().get("x[2].name").toString();
	Assert.assertEquals(StudentName, "Smith");
	
	}
}

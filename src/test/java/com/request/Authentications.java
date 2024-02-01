package com.request;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;

import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.tokenSpec_return;

//import static io.restassured.RestAssured.*;

public class Authentications {
	//basic Authentication
	
	@Test(priority = 1)
	void testbasicAuth() {
		
		given()
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equals(true))
		
		.log().all();
	}
	
	//digest Authentication
	
	@Test(priority = 2)
	void testdigestAuth() {
		
		given()
		.auth().digest("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equals(true))
		
		.log().all();
	}
	//premptive Authentication
	@Test(priority = 3)
	void testpremptiveAuth() {
		
		given()
		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equals(true))
		
		.log().all();
	}
	//bearer Token
	@Test(priority = 4)
	void testbearerTokenAuthentication() {
		String bearertoken = "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";
		
		given()
		.headers("Authentication","Bearer "+bearertoken)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//oAuth2 Token
		@Test(priority = 5)
		void oAuth2Authentication() {
			
			given()
			.auth().oauth2("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")
			
			.when()
			.get("https://api.github.com/user/repos")
			
			.then()
			.statusCode(200)
			.log().all();
		}

}

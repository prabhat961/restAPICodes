package com.request;

import static io.restassured.RestAssured.*;

import java.util.Map;

//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
//import static io.restassured.RestAssured.*;

public class cookiesANdHeadersDemo {
	
	@Test
	void TestCookies() {
		
		given()
		
		.when()
		
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC","Ae3NU9MyNKe14ca06KHA1YcP0rBaaM_AVgbb0See1bME3wIz3NVvQoUvmA")
		.log().all();
		
		
	}
	
	
	@Test
	void getCookiesInfo() {
		
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
		//get Single Cookie
		
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of the cookie is:"+cookie_value);
		
		//get All cookie info
		Map<String, String>cookiesinfo = res.getCookies();
		System.out.println(cookiesinfo.keySet());
		
		for(String k:cookiesinfo.keySet()) {
			System.out.println(k+"         "+cookiesinfo);
		}
	}
		
		
		@Test
		void TestHeaders() {
			
			given()
			
			.when()
			
			.get("https://www.google.com/")
			
			.then()
			.header("Content-type", "text/html:charSet=ISO-8859-1")
			.and()
			.header("Server", "gws")
			.and()
			.header("Content-Encoding", "gzip");
			
			
		}
		
		@Test
		void getHeaderInfo() {
			Response res = given()
			
			.when()
			
			.get("https://www.google.com/");
			
			//get the value of single header
			String headeValue = res.getHeader("Content-type");
			System.out.println("The value in this header is:"+headeValue);
			
			//get Multiple headers
			Headers myHeaders = res.getHeaders();
			
			for(Header hd: myHeaders) {
				System.out.println(hd.getName()+"         "+hd.getValue());
			}
		}
		
		
	

}

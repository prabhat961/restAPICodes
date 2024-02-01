package com.request;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class parsingXMLResponseData {
	
	@Test
	void testXMLResponse() {
		//Approach 1:
//		given()
//		
//		.when()
//		.get("http://restapi.adequateshop.com/api/traveler?page=1")
//		
//		.then()
//		.statusCode(200)
//		.header("ContentType", "application/xml; charset=utf-8");
		//.body("TravelerinformationResponse.page", equals("1"));
		//.body("TravelerinformationResponse.travelers.Travelerinformation.name", equals("Developer123"));
		
		//Approach 2:
		
		Response res =
				given()
				
				.when()
				.get("http://restapi.adequateshop.com/api/traveler?page=1");
				
				Assert.assertEquals(res.getStatusCode(), 200);
				Assert.assertEquals(res.getContentType(), "application/xml; charset=utf-8");
				String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
				Assert.assertEquals(pageNo, "1");
		}
	
	@Test
	void testXMLResponseBody() {
		Response res =
				given()
				
				.when()
				.get("http://restapi.adequateshop.com/api/traveler?page=1");
				
				XmlPath xPath = new XmlPath(res.asString());
				//get Number of travellers in the Response
				List<String> travelerInfoList = xPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
				System.out.println("Total Number of travellers in the list:"+travelerInfoList.size());
				
				//Verify the list count
				Assert.assertEquals(travelerInfoList.size(), 10);
				
				//Verify the passenger name
				List<String> travelerNameList = xPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
				for(String name:travelerNameList) {
					System.out.println(name);
				}
				
				
				
	}

}

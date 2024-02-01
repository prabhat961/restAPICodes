package chaining;
import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;

import static io.restassured.RestAssured.*;

public class createUser {
@Test
void testUserCreation(ITestContext context) {
	Faker faker = new Faker();
	
	JSONObject data = new JSONObject();
	
	data.put("name",faker.name().fullName());
	data.put("gender","Male");
	data.put("email", faker.internet().emailAddress());
	data.put("status","Inactive");
	
	String bearerToken = "83675af451c7abb9e63cd3bd293678263b93e32de034ee6bb10099a94b942d03";
	
	int id = given()
	.headers("Authorization", "Bearer "+bearerToken)
	.contentType("application/json")
	.body(data.toString())
	
	.when()
	.post("https://gorest.co.in/public/v2/users")
	.jsonPath().getInt("id");
	
	System.out.println("Generated id is:"+id);
	
	context.setAttribute("userid", id);
	
	}
}

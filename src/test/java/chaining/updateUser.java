package chaining;
import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

//import static io.restassured.RestAssured.*;

public class updateUser {
	@Test
	void testUpdateUser(ITestContext context) {
		
		int id = (Integer) context.getAttribute("userid");
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name",faker.name().fullName());
		data.put("gender","female");
		data.put("email", faker.internet().emailAddress());
		data.put("status","actove");
		
		String bearerToken = "83675af451c7abb9e63cd3bd293678263b93e32de034ee6bb10099a94b942d03";
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", id)
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}

package chaining;
import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.matchers.RestAssuredMatchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;

public class getUser {
	@Test
	void testgetUser(ITestContext context) {
		int id = (Integer) context.getAttribute("userid");
		String bearerToken = "83675af451c7abb9e63cd3bd293678263b93e32de034ee6bb10099a94b942d03";
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id", id)
				
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then().statusCode(200)
		.log().all();
		
	}

}

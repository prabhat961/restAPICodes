package chaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {
	
	@Test
	void testuserDeletion(ITestContext context) {
	
	String bearerToken = "83675af451c7abb9e63cd3bd293678263b93e32de034ee6bb10099a94b942d03";
	int id = (Integer) context.getAttribute("userid");
	
	given()
	.headers("Authorization", "Bearer "+bearerToken)
	.pathParam("id", id)
	
	.when()
	.delete("https://gorest.co.in/public/v2/users/{id}")
	
	
	.then()
	.statusCode(200)
	.log().all();
	
	
	
	}
	

}

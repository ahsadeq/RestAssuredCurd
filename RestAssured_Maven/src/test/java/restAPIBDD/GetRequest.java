package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {

	@Test
	public void GetCall() {
		RestAssured.given()
				.baseUri("http://localhost:7000")
				.queryParam("id", "1")
				.when()
				.get("employees")
				.then()
				.body("[0].id", Matchers.equalTo(1))
				.body("[0].name", Matchers.equalTo("Pankaj"))
				.body("[0].salary", Matchers.equalTo("10000"))
				.statusCode(200)
				.log()
						//to print everything .all();
				//print the headers 
				//.headers();
				//print only the body
				.body();
				
	}
}

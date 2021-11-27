package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	@Test
	public void PostCall() {
		
		Map<String,Object> Jsonmap=new HashMap<String,Object>();
		Jsonmap.put("name", "Rohan");
		Jsonmap.put("salary", "4000");
		
		RestAssured.given()
		.baseUri("http://localhost:7000")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Jsonmap)
		.when()
		.post("/employees/create")
		.then()
		.statusCode(201)
		.body("name", Matchers.equalTo("Rohan"))
		.body("salary", Matchers.equalTo("4000"))
		.log()
		.body();
		
		
	}

}

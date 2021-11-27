package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	@Test
	public void PutCall() {
		Map<String,Object> Jsonmap=new HashMap<String,Object>();
		Jsonmap.put("name", "Tahseen");
		Jsonmap.put("salary", "3000");
		
		RestAssured.given()
		.baseUri("http://localhost:7000")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Jsonmap)
		.when()
		.put("/employees/22")
		.then()
		.statusCode(200)
		.body("name", Matchers.equalTo("Tahseen"))
		.body("salary", Matchers.equalTo("3000"))
		.log()
		.body();
		
	}

}

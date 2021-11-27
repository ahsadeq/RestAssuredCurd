package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostRequest {
	
	@Test
	public void PostCall() {
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request=RestAssured.given();
		Response response= request.contentType(ContentType.JSON)
								 .accept(ContentType.JSON)
								 .body("{\r\n"
										 +"	\"name\":\"Ahmad\",\r\n"
										 +" \"salary\":\"8000\"\r\n"
										 +"}")
								 .post("/employees/create");
		
		
		String ResponseBody=response.getBody().asString();
		System.out.println(ResponseBody);
		
		int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode, 201);
	}

}

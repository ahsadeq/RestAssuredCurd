package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	@Test
	public void PostCall() {

		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request=RestAssured.given();
		
		
		Map<String,Object> Jsonmap=new HashMap<String,Object>();
		Jsonmap.put("name", "MapGuy");
		Jsonmap.put("salary", "8000");
		
		
		Response response= request.contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				 .body(Jsonmap)
				 .post("/employees/create");
		String ResponseBody=response.getBody().asString();
		System.out.println(ResponseBody);

		int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode, 201);

}
}
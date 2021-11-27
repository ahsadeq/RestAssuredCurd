package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWihParams {
	
	@Test
	public void GetCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request=RestAssured.given();	
		Response response=request.param("id", "1").get("/employees");
		
		String ResponseBody= response.getBody().asString();
		System.out.println(ResponseBody);
		
		
		//verify response code
				int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode, 200);
		
		//verify Response Header
		String ResponseHeader= response.getHeader("Content-Type");
		System.out.println("The Header is "+ResponseHeader);
		System.out.println("All Headers Are "+ response.getHeaders());
		Assert.assertEquals(ResponseHeader,"application/json; charset=utf-8");
		
		//verify Response body
		
		JsonPath jpath = response.jsonPath();
		List <String>names= jpath.get("name");
		Assert.assertEquals(names.get(0), "Pankaj");
	}
	

}

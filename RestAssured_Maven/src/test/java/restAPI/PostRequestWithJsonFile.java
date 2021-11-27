package restAPI;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PostRequestWithJsonFile {
	
	@Test
	public void PostCall() throws IOException {

		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request=RestAssured.given();
	
		String JsonBody=ReadJson("data.json");
		
		Response response= request.contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				 .body(JsonBody)
				 .post("/employees/create");
		String ResponseBody=response.getBody().asString();
		System.out.println(ResponseBody);

		int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode, 201);

}
	
	public String ReadJson(String FilePath) throws IOException {


			return new String(Files.readAllBytes(Paths.get(FilePath))) ;

	}
}
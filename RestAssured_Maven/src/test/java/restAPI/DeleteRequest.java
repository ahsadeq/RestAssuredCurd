package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;




public class DeleteRequest {

    @Test
    public void DeleteCall() {

        RestAssured.baseURI = "http://localhost:7000";
        RequestSpecification request = RestAssured.given();
        Response response=request.delete("/employees/8");

        String ResponseBody = response.getBody().asString();
        System.out.println(ResponseBody);


    }
}

package restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PutRequest {

    @Test
    public void PutCall(){
        RestAssured.baseURI="http://localhost:7000";
        RequestSpecification request=RestAssured.given();
        Map<String,Object> Jsonmap= new HashMap<String,Object>();
        Jsonmap.put("name","Peter");
        Jsonmap.put("salary","8000");

        Response response= request.contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Jsonmap)
                .put("/employees/2");

        String ResponseBody=response.getBody().asString();
        System.out.println(ResponseBody);

        int ResCode=response.getStatusCode();
        Assert.assertEquals(ResCode,200);
    }
}

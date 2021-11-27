package restAPIChaining;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class EndToEndTest {

    @Test
    public void Test1(){
        String ResponseBody;
        String ResponseId;
        //Get Call
        RestAssured.baseURI = "http://localhost:7000";
        RequestSpecification Getrequest=RestAssured.given();
        Response Getresponse=Getrequest.get("/employees");
         ResponseBody=Getresponse.getBody().asString();
        System.out.println(ResponseBody);
        //Post Call

        RequestSpecification postRequest=RestAssured.given();

        JSONObject jobj=new JSONObject();
        jobj.put("name", "Aya");
        jobj.put("salary", "15000");

        Response postresponse= postRequest.contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jobj.toString())
                .post("/employees/create");
        String postResponseBody=postresponse.getBody().asString();
        System.out.println(postResponseBody);

        JsonPath jpath= postresponse.jsonPath();

        ResponseId=jpath.get("id").toString();
        System.out.println("Id coming from Response is "+ ResponseId);
//        PutCall

        RequestSpecification PutRequest=RestAssured.given();
        jobj.put("name","AhmadPut");
        jobj.put("salary","50000");

        Response PutResponse=PutRequest.contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jobj.toString())
                .put("/employees/" + ResponseId);
        ResponseBody=PutResponse.getBody().asString();
        System.out.println(ResponseBody);


        //Delete Call

        RequestSpecification Deleterequest = RestAssured.given();
        Response Deleteresponse=Deleterequest.delete("/employees/" + ResponseId);

        ResponseBody = Deleteresponse.getBody().asString();
        System.out.println(ResponseBody);

    }
}

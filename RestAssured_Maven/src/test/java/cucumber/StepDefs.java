package cucumber;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefs {

	RequestSpecification request;
	Response response;
	
	@Given ("^I have the base URI \"([^\"]*)\"$")
	public void i_have_the_base_uri_something(String BaseURI) {
		request=RestAssured.given()
				.baseUri(BaseURI);
		
	}
	@When ("^I perform the Get Operation$")
	public void i_perform_the_get_operation() {
		response=request.get();
		
	}
	@Then ("^I should Get the response$")
	public void i_should_get_the_response() {
		Assert.assertNotNull(response);
	}
	@And ("^Response Code Should be \"([^\"]*)\"$")
	public void Response_code_should_be(int Code) {
		int ActualResCode=response.getStatusCode();
		Assert.assertEquals(ActualResCode, Code);
		
	}
}

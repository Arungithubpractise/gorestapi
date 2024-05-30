package Stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.Utils;  



public class Usercreation extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	static String place_id;
	
	@Given("create a user")
	public void create_a_user() throws IOException {
		
		res=given().spec(requestSpecification());
				//.body(data.addPlacePayLoad(name,language,address));
		

	}

	@When("user is created with {string} http request")
	public void user_is_created_with_http_request(String string) {
	    
	}

	@Then("check data is created with status code {int} created")
	public void check_data_is_created_with_status_code_created(Integer int1) {
	    
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	  
	}




}

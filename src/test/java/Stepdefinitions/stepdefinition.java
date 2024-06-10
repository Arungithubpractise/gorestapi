package Stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

import resources.GorestAPIResources;
import resources.Testdatabuild;
import utils.Utils;  
import static org.junit.Assert.*;



public class stepdefinition extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	Testdatabuild test = new Testdatabuild();
	
	static String user_id;
	
	@Given("create a user")
	public void create_a_user() throws IOException 
	{
		res=given().log().all().spec(requestSpecification())
				.body(Testdatabuild.setupdata());
					
	}
	
	@When("user uses {string}  with {string} http request")
	public void user_uses_with_http_request(String resource, String method) 
	{
		GorestAPIResources resourceAPI=GorestAPIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().log().all().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().log().all().get(resourceAPI.getResource());
	   
	}
		
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int no) {
		
		Assert.assertEquals(no, response.getStatusCode());
	}

	
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key	, String expectedvalue) {
		
		Assert.assertEquals(expectedvalue, getJsonPath(response, key));
		//Assert.assertEquals(expectedvalue, actual);
	  
	}
	
	@Given("DeleteUser Payload")
	public void delete_user_payload() throws IOException {
	      
		 user_id=getJsonPath(response,"id");
		 
		 res =given().spec(requestSpecification()).body(response.);
	}
	





}

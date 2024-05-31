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
import resources.Testdatabuild;
import utils.Utils;  



public class stepdefinition extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	Testdatabuild test = new Testdatabuild();
	
	static String place_id;
	
	@Given("create a user")
	public void create_a_user() throws IOException 
	{
		/*res=given().spec(requestSpecification())
				.body(Testdatabuild.setupdata());*/
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://gorest.co.in").setContentType(ContentType.JSON).setAccept(ContentType.JSON).build();
		
		ResponseSpecBuilder v = new ResponseSpecBuilder();
		res =given().spec(req).body(Testdatabuild.setupdata());
				
	}
	
   
	
	@When("user is created with {string} http request")
	public void user_is_created_with_http_request(String method)
	{
		
		response = res.when().post("/public/v2/users/1").then().spec(resspec).extract().response();
		
		/*GorestAPIResources resourceAPI=GorestAPIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());*/
	   
	}
	@Then("check data is created with status code {int} created")
	public void check_data_is_created_with_status_code_created(Integer int1) {
		
		assertEquals(response.getStatusCode(),201);
	    
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key	, String expectedvalue) {
		
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		
		assertEquals(js.get(key).toString(),expectedvalue);
	  
	}




}

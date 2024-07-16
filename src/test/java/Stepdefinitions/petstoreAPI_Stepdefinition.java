package Stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Testdatabuild;
import resources.petstoreAPIResources;
import utils.petstoreAPI_Utils;

public class petstoreAPI_Stepdefinition extends petstoreAPI_Utils{
	
	 File file;
	 RequestSpecification  res;
	 public static Response createuserresponse;
	 public static Response imageuploadresponse;
	
	 
	 @Given("create a pet")
	 public void create_a_pet() throws IOException 
	 {
		 res = given().log().all().spec(createapet()).body(Testdatabuild.petdata());
	 }

	 @When("we will use {string}  with {string} http request")
	 public void we_will_use_with_http_request(String resource, String method) {
		 petstoreAPIResources resourceAPI = petstoreAPIResources.valueOf(resource);
			System.out.println(resourceAPI.getResource());

			//resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
			
			System.out.println(method);

			if (method.equalsIgnoreCase("POST"))
				createuserresponse = res.when().log().all().post(resourceAPI.getResource());
			else if (method.equalsIgnoreCase("GET"))
				createuserresponse = res.when().log().all().get(resourceAPI.getResource());
			else if (method.equalsIgnoreCase("PUT"))
				createuserresponse = res.when().log().all().get(resourceAPI.getResource());
			else if (method.equalsIgnoreCase("DELETE"))
				createuserresponse = res.when().log().all().get(resourceAPI.getResource());
	 }

	 @Then("the API call should get success with status code {int}")
	 public void the_api_call_should_get_success_with_status_code(int no) {
		 assertEquals(createuserresponse.getStatusCode(), no);
	 }

	 
	@Given("I have a valid JPEG file")
	public void i_have_a_valid_jpeg_file() 
	{
	file = new File("C:\\Users\\admin\\eclipse-workspace\\Restassured\\cat(JPEG).jpeg");
	
	}
	
	@When("I {string} the JPEG file with http {string} method")
	public void i_the_jpeg_file_with_http_method(String resource, String method) throws IOException 
	{
		 res = given().log().all().spec(uploadImage()).urlEncodingEnabled(false);
			
	     petstoreAPIResources resourceAPI = petstoreAPIResources.valueOf(resource);
			System.out.println(resourceAPI.getResource());
			
			if (method.equalsIgnoreCase("POST"))
				imageuploadresponse = res.when().log().all().post(resourceAPI.getResource());
			else if (method.equalsIgnoreCase("GET"))
				imageuploadresponse = res.when().log().all().get(resourceAPI.getResource());
			else if (method.equalsIgnoreCase("PUT"))
				imageuploadresponse = res.when().log().all().get(resourceAPI.getResource());
			else if (method.equalsIgnoreCase("DELETE"))
				imageuploadresponse = res.when().log().all().get(resourceAPI.getResource());
	}
	

	@Then("the upload should be successful")
	public void the_upload_should_be_successful() 
	{
		assertEquals(response.statusLine(), "Created");
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int no) 
	{
		assertEquals(response.statusCode(), no);
	}


	@Then("the response should contain the file URL")
	public void the_response_should_contain_the_file_url() 
	{
		
		response.then().body("Url", notNullValue());
		
		

}
}




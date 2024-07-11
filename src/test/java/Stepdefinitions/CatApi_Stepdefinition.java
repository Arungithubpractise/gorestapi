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
import resources.catAPIResources;
import utils.CatApi_Utils;

public class CatApi_Stepdefinition extends CatApi_Utils{
	
	 File file;
	 RequestSpecification  res;
	 public static Response response;
	
	@Given("I have a valid JPEG file")
	public void i_have_a_valid_jpeg_file() 
	{
	file = new File("./cat(JPEG).jpeg");
	
	}
	
	@When("I upload the JPEG file to {string} with http {string} method")
	public void i_upload_the_jpeg_file_to_with_http_method(String resource, String method) throws IOException {
	   
     res = given().log().all().spec(uploadImage()).urlEncodingEnabled(false);
		
     catAPIResources resourceAPI = catAPIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if (method.equalsIgnoreCase("POST"))
			response = res.when().log().all().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().log().all().get(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("PUT"))
			response = res.when().log().all().get(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("DELETE"))
			response = res.when().log().all().get(resourceAPI.getResource());
	}

	

	/*@Then("the upload should be successful")
	public void the_upload_should_be_successful() 
	{
		assertEquals(response.statusLine(), "Created");
	}*/

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int no) 
	{
		assertEquals(response.statusCode(), no);
	}


	@Then("the response should contain the file URL")
	public void the_response_should_contain_the_file_url() 
	{
		
		response.then().body("Url", notNullValue());
		
		
	/*String url = CatApi_Utils.getaccesstoken(response, "url");
	
	assertTrue( response.then().extract().jsonPath()
	        .getString("url")
	        .contains((CharSequence) notNullValue());*/
		
		
	}




}

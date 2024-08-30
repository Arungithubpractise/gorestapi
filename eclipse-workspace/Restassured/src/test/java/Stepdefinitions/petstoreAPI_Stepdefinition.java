package Stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import Petstore_Deserialization_pojo.GetData;
import Petstore_Deserialization_pojo.tags;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Testdatabuild;
import resources.petstoreAPIResources;
import utils.petstoreAPI_Utils;

public class petstoreAPI_Stepdefinition extends petstoreAPI_Utils {

	File file;
	RequestSpecification res;
	public static Response createpetresponse;
	public static Response imageuploadresponse;

	@Test
	@Epic("creating a pet")
	@Feature("creating a pet with POST method")
	@Severity(SeverityLevel.NORMAL)
	@Story("Pet store API")
	@Description("creating a pet to upload a image")
	@Link("https://petstore.swagger.io/")

	@Given("create a pet")
	public void create_a_pet() throws IOException {
		res = given().log().all().spec(createapet()).body(Testdatabuild.petdata());
	}

	@When("we will use {string}  with {string} http request")
	public void we_will_use_with_http_request(String resource, String method) 
	{
		petstoreAPIResources resourceAPI = petstoreAPIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		/*//resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		
		System.out.println(method);

		if (method.equalsIgnoreCase("POST"))
			createpetresponse = res.when().log().all().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			createpetresponse = res.when().log().all().get(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("PUT"))
			createpetresponse = res.when().log().all().get(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("DELETE"))
			createpetresponse = res.when().log().all().get(resourceAPI.getResource());
		
System.out.println("Response for createpet" +petstoreAPI_Utils.getresponsestring(createpetresponse));*/
 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	 
	 createpetresponse = res.when().log().all().post(resourceAPI.getResource());
	 GetData gd = res.when().log().all().post(resourceAPI.getResource()).as(GetData.class);	 
			
				//.post("https://petstore.swagger.io/v2/pet").as(GetData.class);
			
			System.out.println("**************************");
			
			System.out.println(gd.getCategory().getName());
			System.out.println(gd.getCategory().getId());
			
			System.out.println(gd.getId());
			System.out.println(gd.getName());
			
			System.out.println("photourls " +gd.getPhotoUrls());
			
		      List<tags> tags = gd.getTags();
			
		      for(int i=0;i<tags.size();i++)
		   		{
		   			if(tags.get(i).getName().equalsIgnoreCase("string"))
		   					{
		    				System.out.println(tags.get(i).getName());
		   					}
		   			if(tags.get(i).getId()==0)
						{
					System.out.println(tags.get(i).getId());
						}
		   		}
	}

	@Then("the API call should get success with status code {int}")
	public void the_api_call_should_get_success_with_status_code(int no) {
		assertEquals(createpetresponse.getStatusCode(), no);
	}

	@Test
	@Epic("upload an image")
	@Feature("upload an image with POST method")
	@Severity(SeverityLevel.NORMAL)
	@Story("Pet store API")
	@Description("upload a image for a pet created")
	@Link("https://petstore.swagger.io/")
	
	@Given("I have a valid JPEG file")
	public void i_have_a_valid_jpeg_file() {
		file = new File("C:\\Users\\admin\\eclipse-workspace\\Restassured\\cat(JPEG).jpeg");

	}

	@When("I {string} the JPEG file with http {string} method")
	public void i_the_jpeg_file_with_http_method(String resource, String method) throws IOException {
		res = given().log().all().spec(
				uploadImage().pathParam("id", petstoreAPI_Utils.getid(createpetresponse)).urlEncodingEnabled(false));

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

		System.out.println("Response for uploadimage" + petstoreAPI_Utils.getresponsestring(imageuploadresponse));

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int no) {
		assertEquals(imageuploadresponse.statusCode(), no);
	}

}

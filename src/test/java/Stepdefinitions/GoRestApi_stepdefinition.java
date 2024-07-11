package Stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.GorestAPIResources;
import resources.Testdatabuild;
import utils.GoRestApi_Utils;


@Epic("Validating Gorest Api for a user")
@Feature("Login Page Tests")

@Severity(SeverityLevel.NORMAL)


@Story("Title of Login Page")


public class GoRestApi_stepdefinition extends GoRestApi_Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Testdatabuild test = new Testdatabuild();
	static Response response;
	static String id;

	@Given("create a user with {string}  {string}")
	public void create_a_user_with(String gender , String status) throws IOException {
	    
		res = given().log().all().spec(GoRestApirequestSpecification()).body(Testdatabuild.setupdata(gender, status));
		
	}

	@When("user uses {string}  with {string} http request")
	public void user_uses_with_http_request(String resource, String method) {
		GorestAPIResources resourceAPI = GorestAPIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		//resspec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		
		System.out.println(method);

		if (method.equalsIgnoreCase("POST"))
			response = res.when().log().all().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().log().all().get(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("PUT"))
			response = res.when().log().all().get(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("DELETE"))
			response = res.when().log().all().get(resourceAPI.getResource());

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int no) 
	{
		assertEquals(response.getStatusCode(), no);
	
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedvalue) 
	{
		assertEquals(getresponsestring(response, key),expectedvalue);	
	}

	
	 

	@Given("fetch the data created of user with {string}")
	public void fetch_the_data_created_of_user_with(String getuser) throws IOException {

		id = getresponsestring(GoRestApi_stepdefinition.response, "id");

		System.out.println(id);

		res = given().log().all().spec(GoRestApirequestSpecification()).queryParam("id", id);
		user_uses_with_http_request(getuser, "GET");

	}
	
	@Given("UpdateUser with {string}")
	public void update_user_with(String updateuser) throws IOException 
	{
		res = given().log().all().spec(GoRestApirequestSpecification()).body(Testdatabuild.updatedata()).queryParam("id", id);;
		user_uses_with_http_request(updateuser, "PUT");
	}

	@Given("Delete the user with {string}")
	public void delete_the_user_with(String deleteuser) throws IOException {

		System.out.println("check " + GoRestApi_stepdefinition.id);
		
		res = given().spec(GoRestApirequestSpecification()).queryParam("id", GoRestApi_stepdefinition.id);
		
		user_uses_with_http_request(deleteuser, "DELETE");
		
	}

}

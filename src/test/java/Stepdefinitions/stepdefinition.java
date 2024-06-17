package Stepdefinitions;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.GorestAPIResources;
import resources.Testdatabuild;
import utils.Utils;

public class stepdefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Testdatabuild test = new Testdatabuild();
	static Response response;
	static String id;

	@Given("create a user with {string}  {string}")
	public void create_a_user_with(String gender , String status) throws IOException {
	    
		res = given().log().all().spec(requestSpecification()).body(Testdatabuild.setupdata(gender, status));
		
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
		//assertEquals(response.getStatusCode(), no);
		Assert.assertEquals(response.getStatusCode(), no);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedvalue) 
	{
		Assert.assertEquals(expectedvalue, getresponsestring(response, key));
		// Assert.assertEquals(expectedvalue, actual);
	}

	/*
	 * @Then("verify id created to {string} using {string}") public void
	 * verify_id_created_to_using(String string, String string2) throws IOException
	 * { id = getresponsestring(response,"id");
	 * System.out.println("idddddddddddddddd" +id);
	 * 
	 * res=given().spec(requestSpecification()).queryParam("id", id); //
	 * user_uses_with_http_request(resource,"GET"); // String id1 =
	 * getresponsestring(response,"id"); // assertEquals(actualName,expectedName); }
	 */

	@Given("fetch the data created of user with {string}")
	public void fetch_the_data_created_of_user_with(String getuser) throws IOException {

		id = getresponsestring(stepdefinition.response, "id");

		System.out.println(id);

		res = given().log().all().spec(requestSpecification()).queryParam("id", id);
		user_uses_with_http_request(getuser, "GET");

	}
	
	@Given("UpdateUser with {string}")
	public void update_user_with(String updateuser) throws IOException 
	{
		res = given().log().all().spec(requestSpecification()).body(Testdatabuild.updatedata()).queryParam("id", id);;
		user_uses_with_http_request(updateuser, "PUT");
	}

	@Given("Delete the user with {string}")
	public void delete_the_user_with(String deleteuser) throws IOException {

		System.out.println("check " + stepdefinition.id);
		
		res = given().spec(requestSpecification()).queryParam("id", stepdefinition.id);
		
		user_uses_with_http_request(deleteuser, "DELETE");
		
	}

}

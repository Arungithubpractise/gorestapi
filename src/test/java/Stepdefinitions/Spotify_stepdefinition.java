package Stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import resources.SpotifyAPIResources;
import resources.Testdatabuild;
import utils.Spotify_Utils;


@Epic("Validating Gorest Api for a user")
@Feature("Login Page Tests")

@Severity(SeverityLevel.NORMAL)


@Story("Title of Login Page")

public class Spotify_stepdefinition extends Spotify_Utils {

	Object clientid;
	String spotifyclientid;
	String clientsecret;
	String spotifyclientsecret;
	String authorizationcode;
	public static Response response;
	RequestSpecification res;
	String accesstoken;
	public static Response playlistresponse;
	
	@Given("Hitting a Authorization url in browser with client id and client secret to get authorization code")
	public void hitting_a_authorization_url_in_browser_with_client_id_and_client_secret_to_get_authorization_code() 
	{
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ops.addArguments("--headless", "--disable-gpu",String.format("--window-size=%d,%d", (int)size.getWidth(),(int)size.getHeight()));
        ops.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
        WebDriver driver = new ChromeDriver(ops);

	    driver.get("https://accounts.spotify.com/authorize?client_id=9393418e0d1e4ccdae4c92875eb5b438&redirect_uri=https://www.google.com/&state=karnataka&scope=playlist-modify-public playlist-read-private playlist-modify-private&response_type=code");

		driver.findElement(By.id("login-username")).sendKeys("arunrpea16@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Dummy@123");
		driver.findElement(By.xpath("//span[text()='Log In']")).click();

		String url = driver.getCurrentUrl();		

		String partialcode = url.split("code=")[0];

		authorizationcode = partialcode.split("&state")[0];
		System.out.println(authorizationcode);
	 
	}
	
@When("I request an access token using the authorization {string} with {string} http request")
public void i_request_an_access_token_using_the_authorization_with_http_request(String resource, String method) throws IOException {
	
	RequestSpecification res = given().log().all().spec(SpotifyrequestSpecification());
	
	SpotifyAPIResources resourceAPI = SpotifyAPIResources.valueOf(resource);
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

@Then("I should receive a valid access token")
public void i_should_receive_a_valid_access_token() 
{
	accesstoken = Spotify_Utils.getaccesstoken(response);
	System.out.println(accesstoken);
}

}
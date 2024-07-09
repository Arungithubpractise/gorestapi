package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import Stepdefinitions.Spotify_stepdefinition;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Spotify_Utils {
	
	AuthenticationScheme accessToken;

	public static RequestSpecification req;
	
	public RequestSpecification SpotifyrequestSpecification() throws IOException
	{
		
		
		if(req==null)   // it will make shure when 2nd runtest case is running it is not overlapping previous one in looging.txt
		{
		PrintStream log =new PrintStream(new FileOutputStream("Spotifylogging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("SporifybaseUrl"))		
				 .addQueryParam("client_id", getGlobalValue("spotifyclientid"))
				 .addQueryParam("client_secret", getGlobalValue("spotifyclientsecret"))
				 .addQueryParam("grant_type", "client_credentials")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();	 
		 return req;
		}
		return req;	
		
	}
	
	public RequestSpecification createplaylist() throws IOException
	{
		
		if(req==null) 
		{
		PrintStream log =new PrintStream(new FileOutputStream("Spotifylogging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("Spotifyuserid"))
				 .setAuth(accessToken)
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();	 
		 return req;
		}
		return req;	
		
	}
		
	
	public  String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("./src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
			
	}
	
	
	public  String getresponsestring(Response response,String key)
	{
		System.out.println(key);
		System.out.println("----------" +response);
		
		  String resp=response.asString();
		  
		  System.out.println("----------" +resp);
		  
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
	

	public  static String getaccesstoken(Response response)
	{
		
		System.out.println(response);
		  String resp=response.asString();
		  
		  System.out.println("----------" +resp);
			
		JsonPath jsonPath = new JsonPath(resp);
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);
		
		return accessToken;
	}
	
	
	
}

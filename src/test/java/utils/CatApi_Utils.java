package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import Stepdefinitions.Spotify_stepdefinition;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Testdatabuild;

public class CatApi_Utils {
	
	public static RequestSpecification req;
	public static RequestSpecification playlistreq;
	
	public RequestSpecification uploadImage() throws IOException
	{	
		if(req==null)   // it will make shure when 2nd runtest case is running it is not overlapping previous one in looging.txt
		{
		PrintStream log =new PrintStream(new FileOutputStream("CatApilogging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("CapApibaseurl"))		
				 .addHeader("Content-Type", "multipart/form-data")
				 .addHeader("x-api-key", "17d94b92-754f-46eb-99a0-65be65b5d18f")
				 .addFormParam("file", "cat(JPEG).jpeg")
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
	
	
	public static  String getresponsestring(Response response)
	{
		
		System.out.println("----------" +response);
		
		  String resp=response.asString();
		  
		  System.out.println("----------" +resp);
		  
		JsonPath   js = new JsonPath(resp);
		return js.get().toString();
	}
	
	public  static String getaccesstoken(Response response,String stringname)
	{
		
		System.out.println(response);
		  String resp=response.asString();
		  
		  System.out.println("----------" +resp);
			
		JsonPath jsonPath = new JsonPath(resp);
		 String url = jsonPath.getString("stringname");
		System.out.println(url);
		
		return url;
	}	
	
}

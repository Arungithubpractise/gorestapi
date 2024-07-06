package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoRestApi_Utils {

	public static RequestSpecification req;
	
	public RequestSpecification GoRestApirequestSpecification() throws IOException
	{
		String Token = getGlobalValue("GoResttoken");
		//GoResttoken"c975dc2ab2462b4583c7f3e54a07a22557899cb772c3480afd1e402c4b82d292";
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("GoRestApilogging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("GoRestbaseUrl"))
				 .addHeader("Authorization", "Bearer "+Token)
				 .setAccept(ContentType.JSON)
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
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
	
	
	
	public  String getid(Response response)
	{
		
		System.out.println(response);
		  String resp=response.asString();
		  
		  System.out.println("----------" +resp);
		
		JsonPath js = new JsonPath(resp);
		String id  = js.get("id");
		
		return id;
	}
	
	
	
}

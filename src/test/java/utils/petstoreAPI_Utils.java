package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.petstoreAPIResources;

public class petstoreAPI_Utils {
	
	public static RequestSpecification createpetreq;
	public static RequestSpecification imageuploadreq;
	public static RequestSpecification playlistreq;
	
	public static String id;
	
	
	public RequestSpecification createapet() throws IOException
	{	
		if(createpetreq==null)   // it will make shure when 2nd runtest case is running it is not overlapping previous one in looging.txt
		{
		PrintStream log =new PrintStream(new FileOutputStream("CatApilogging.txt"));
		createpetreq=new RequestSpecBuilder().setBaseUri(getGlobalValue("petstoreBaseuri"))		
				 .addHeader("Content-Type", "application/json")
				 .addHeader("accept", "application/json")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();	 
		 return createpetreq;
		}
		return createpetreq;	
		
	}
	
	public RequestSpecification uploadImage() throws IOException
	{	
		if(imageuploadreq==null)   // it will make shure when 2nd runtest case is running it is not overlapping previous one in looging.txt
		{
		PrintStream log =new PrintStream(new FileOutputStream("CatApilogging.txt"));			
		imageuploadreq=new RequestSpecBuilder().setBaseUri(getGlobalValue("petstoreBaseuri"))		
				 .addHeader("Content-Type", "multipart/form-data")
				 .addFormParam("additionalMetadata", "Test")
				 .addMultiPart("file", new File("C:\\Users\\admin\\eclipse-workspace\\Restassured\\cat(JPEG).jpeg"),  "image/png")
				
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();		
		 
		 return imageuploadreq;
		}
		return imageuploadreq;	
		
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
	
	public  static String getid(Response response)
	{
		
		System.out.println(response);
		  String resp=response.asString();
		  
		  System.out.println("----------" +resp);
			
		  JsonPath jsonPath = new JsonPath(resp);
			  id = jsonPath.getString("id");
			System.out.println(id);
				
		return id;
	}	
	
}

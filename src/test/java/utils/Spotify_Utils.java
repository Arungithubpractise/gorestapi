package utils;

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

public class Spotify_Utils {

	public static RequestSpecification req;
	
	/*public RequestSpecification requestSpecification() throws IOException
	{
		String Token = getGlobalValue("GoResttoken");
		//GoResttoken"c975dc2ab2462b4583c7f3e54a07a22557899cb772c3480afd1e402c4b82d292";
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				 .addHeader("Authorization", "Bearer "+Token)
				 .setAccept(ContentType.JSON)
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;		
	}*/
	
	public RequestSpecification SpotifyrequestSpecification() throws IOException
	{
		//String Token = "c975dc2ab2462b4583c7f3e54a07a22557899cb772c3480afd1e402c4b82d292";
		
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
		

		/*String response = given().urlEncodingEnabled(false) //This is usually recommended, but it can be useful to disable URL encoding
				.queryParams("client_id", "905f333391b643669dfdf6b0f98bc5ee")
				.queryParams("client_secret", "29d45b172e58470c99d221da20abe5d9")
				.queryParams("grant_type", "client_credentials")
				.post("https://accounts.spotify.com/api/token").asString();*/
	
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

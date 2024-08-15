package demo;
import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyData;
import pojo.GetData;
import pojo.Testdatabuild;
import pojo.tags;

public class Test {

	public static void main(String[] args) {
	
		
		String response = 	given()
				.header("Content-Type", "application/json")
			    .header("accept", "application/json")
			    .body(Testdatabuild.petdata())
				.post("https://petstore.swagger.io/v2/pet").asString();
		
		
		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		
		long  id = jsonPath.getLong("id");
		//long logid = id;
		
		String status = jsonPath.getString("status");
		String name1 = jsonPath.getString("name");
		String name = jsonPath.getString("category.name");
		String tagid = jsonPath.getString("tags.id");
		String photo = jsonPath.getString("photoUrls");
		
		System.out.println(id);
		System.out.println(status);
		System.out.println(name);
		System.out.println(name1);
		System.out.println(tagid);
		System.out.println(photo);
		
	GetData gd = 	given()
		.header("Content-Type", "application/json")
	    .header("accept", "application/json")
	    .body(Testdatabuild.petdata())
		.post("https://petstore.swagger.io/v2/pet").as(GetData.class);
	
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
	
	//System.out.println("tags " +gd.getTags());
	
	//GetData gc=	given()
		//.when().log().all()
	//	.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetData.class);
	
	//System.out.println(gd.getCategory().ge);
	//System.out.println(gd.getName());
	//System.out.println(gd.getTags());
	//System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	
	
//	List<Api> apiCourses=gc.getCourses().getApi();
//	for(int i=0;i<apiCourses.size();i++)
//	{
//		if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
//				{
//			System.out.println(apiCourses.get(i).getPrice());
//				}
//	}
	
	
	
	
	
	
	
	
	
	//Get the course names of WebAutomation
			
	
//	ArrayList<String> a= new ArrayList<String>();
//			
//			
//			List<pojo.WebAutomation> w=gc.getCourses().getWebAutomation();
//			
//			for(int j=0;j<w.size();j++)
//			{
//				a.add(w.get(j).getCourseTitle());
//			}
//			
//			List<String> expectedList=	Arrays.asList(courseTitles);
//			
//			Assert.assertTrue(a.equals(expectedList));
//			
			
			
	
	
	
	
	
	
	
	
	
	
   		
	}
		
	}

	



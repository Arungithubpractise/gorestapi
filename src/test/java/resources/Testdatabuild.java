package resources;

import com.github.javafaker.Faker;

import pojo.user;


public class Testdatabuild {
	
	static Faker faker;
	static user use;
	
	public static user setupdata()
	{
		faker = new Faker();
		use = new user();
				
		use.setId(faker.idNumber().hashCode()); 
		use.setName(faker.name().username());
		//use.setFirstname(faker.name().firstName()); 
		use.setGender("Male");
		use.setEmail(faker.internet().safeEmailAddress()); 
		use.setStatus("Active"); 
		//use.setPassword(faker.internet().password (5, 10)); 
		//use.setPhone(faker.phoneNumber().cellPhone());
		return use;
		
		
	/*	use = new user();
		
		use.setId(1);
		use.setName("govind kumar");
		use.setEmail("govind@gmail.com");
		use.setGender("Male");
		use.setStatus("Active"); 
		
		return use;*/
			
		
	}

}

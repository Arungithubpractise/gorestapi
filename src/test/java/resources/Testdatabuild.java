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
		use.setGender("Male");
		use.setEmail(faker.internet().safeEmailAddress()); 
		use.setStatus("Active"); 
		return use;
		
		
	}
	
}

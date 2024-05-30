package resources;

import com.github.javafaker.Faker;

import pojo.user;


public class Testdatabuild {
	
	Faker faker;
	user use;
	
	public void setupdata()
	{
		faker = new Faker();
		use = new user();
		
		use.setId(0);
		
		use.setId(faker.idNumber().hashCode()); 
		use.setUsername(faker.name().username());
		use.setFirstname(faker.name().firstName()); 
		use.setLastname(faker.name().lastName());
		use.setEmail(faker.internet().safeEmailAddress()); 
		use.setPassword(faker.internet().password (5, 10)); 
		use.setPhone(faker.phoneNumber().cellPhone());
	}

}

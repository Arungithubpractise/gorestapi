package pojo;

public class Testdatabuild {
	
	/*static Faker faker;
	static user use;
	
	public static user setupdata(String gender, String status)
	{
		faker = new Faker();
		use = new user();
				
		use.setId(faker.idNumber().hashCode()); 
		use.setName(faker.name().username());
		use.setGender(gender);
		use.setEmail(faker.internet().safeEmailAddress()); 
		use.setStatus(status); 
		return use;
		
		
	}*/
	
	public static String updatedata()
	{
		String Str = "{\"name\":\"Arun\",\"email\":\"user_mail\",\"status\":\"active\"}";
		return Str;
	}
		
	
	public static String playlistbody()
	{
		String Str = "{\r\n"
				+ "    \"name\": \"Arunkumar Playlist\",\r\n"
				+ "    \"description\": \"Creating New playlist description\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}";
		
		return Str;
	}
	
	public static String petdata()
	{
		String st = "{\"id\":0,\"category\":{\"id\":0,\"name\":\"string\"},\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"available\"}'";
		return st;
		
}
}

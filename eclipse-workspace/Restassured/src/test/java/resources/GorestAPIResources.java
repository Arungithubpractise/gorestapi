package resources;

public enum GorestAPIResources 
{
	createuserApi("/public/v2/users"),
	getuserApi("/public/v2/users/"),
	updateuserApi("/public/v2/users/"),
	deleteuserApi("/public/v2/users/");
	
	private String resource;
	
	GorestAPIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
	

}

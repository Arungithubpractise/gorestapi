package resources;
//enum is special class in java which has collection of constants or  methods
public enum GorestAPIResources {
	
	createuserApi("/public/v2/users"),
	getuserApi("/public/v2/users/1"),
	updateuserApi("/public/v2/users/1"),
	deleteuserApi("/public/v2/users/1");
	
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

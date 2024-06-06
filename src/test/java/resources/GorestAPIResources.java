package resources;
//enum is special class in java which has collection of constants or  methods
public enum GorestAPIResources {
	
	createuser("/public/v2/users/1"),
	getuser("/public/v2/users/1"),
	updateuser("/public/v2/users/1"),
	deleteuser("/public/v2/users/1");
	
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

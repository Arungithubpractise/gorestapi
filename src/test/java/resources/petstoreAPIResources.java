package resources;

public enum petstoreAPIResources 
{
	createPetApi("/v2/pet"),
	upload("/v1/images/upload");
	
	private String resource;
	
	petstoreAPIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
	

}

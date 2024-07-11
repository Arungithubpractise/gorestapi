package resources;

public enum catAPIResources 
{
	
	upload("/v1/images/upload");
	
	private String resource;
	
	catAPIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
	

}

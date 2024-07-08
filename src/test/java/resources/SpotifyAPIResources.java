package resources;

public enum SpotifyAPIResources 
{
	Token("/api/token");
	
	private String resource;
	
	SpotifyAPIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
	

}

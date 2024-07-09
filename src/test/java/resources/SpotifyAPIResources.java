package resources;

public enum SpotifyAPIResources 
{
	Token("/api/token");
	//createplaylistApi("playlists");
	
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

package resources;

public enum SpotifyAPIResources 
{
	//Spotifyuserid(resource) = "317gyhsluh6xwyu23hi6clu3yzcu";
	
	Token("/api/token"),
	createplaylistApi("/v1/users/317gyhsluh6xwyu23hi6clu3yzcu/playlists");

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

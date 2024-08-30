package resources;

public enum petstoreAPIResources 
{
	createPetApi("/v2/pet"),
	uploadImage("/v2/pet/{id}/uploadImage");

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

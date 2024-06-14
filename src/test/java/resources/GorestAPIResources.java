package resources;

public class GorestAPIResources {
	
	
	public enum GorestAPIResources {
		
		createuserApi("/public/v2/users"),
		getuserApi("/public/v2/users/{username}"),
		updateuserApi("/public/v2/users/{username}"),
		deleteuserApi("/public/v2/users/{username}");
		
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


}

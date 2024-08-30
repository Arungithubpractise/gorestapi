package Petstore_Deserialization_pojo;

import java.util.List;

public class GetData {
	
	private long id;
	private Category category;
    private String name;
    private List<String> photoUrls;
    private List<tags> tags;
    private String status;
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<tags> getTags() {
		return tags;
	}
	public void setTags(List<tags> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	
}

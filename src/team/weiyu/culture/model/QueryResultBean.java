package team.weiyu.culture.model;


public class QueryResultBean {

	private String name;
	private String relation;
	private String object;
	private int linked;
	private String images;
	
	public QueryResultBean(String name, String relation, String object,int linked, String images) {
		super();
		this.name = name;
		this.object = object;
		this.relation = relation;
		this.linked = linked;
		this.images = images;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public int getLinked() {
		return linked;
	}
	public void setLinked(int linked) {
		this.linked = linked;
	}
	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
}

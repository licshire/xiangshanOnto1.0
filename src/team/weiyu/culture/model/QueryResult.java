package team.weiyu.culture.model;

import java.util.ArrayList;

public class QueryResult {
	
	private String name;
	private ArrayList<QueryResult> children;
	private String relation;
	private int linked;
	private String images;
	
	public QueryResult(String name, ArrayList<QueryResult> children, String relation, int linked, String images) {
		super();
		this.name = name;
		this.children = children;
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
	public ArrayList<QueryResult> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<QueryResult> children) {
		this.children = children;
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

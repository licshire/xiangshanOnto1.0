package team.weiyu.culture.model;

import java.util.ArrayList;

public class CatalogInstanceNode {

	private String name;
	private ArrayList<CatalogInstanceNode> children;
	private final String icon = "./icon/instanceIcon.gif";
	private String relation;
	private int linked;
	private String images;
	
	public CatalogInstanceNode(String name, ArrayList<CatalogInstanceNode> children, String relation, int linked,
			String images) {
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

	public ArrayList<CatalogInstanceNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<CatalogInstanceNode> children) {
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

	public String getIcon() {
		return icon;
	}
	
	
	
}

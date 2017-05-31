package team.weiyu.culture.model;

import java.util.ArrayList;

public class CatalogClassNode {
	
	private String name;
	private ArrayList<CatalogClassNode> children;
	private final String iconOpen = "./icon/foldericon_alter.gif";
	private final String iconClose = "./icon/unfoldericon_alter.gif";
	private final String icon = "./icon/unfoldericon_alter.gif";
	private String relation;
	private int linked;
	private String images;
	private String isParent;
	
	public CatalogClassNode(String name, ArrayList<CatalogClassNode> children, String relation, int linked,
			String images,String isParent) {
		super();
		this.name = name;
		this.children = children;
		this.relation = relation;
		this.linked = linked;
		this.images = images;
		this.setIsParent(isParent);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CatalogClassNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<CatalogClassNode> children) {
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

	public String getIconOpen() {
		return iconOpen;
	}

	public String getIconClose() {
		return iconClose;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getIcon() {
		return icon;
	}

	
}

package team.weiyu.culture.service;

import java.util.ArrayList;

import team.weiyu.culture.model.CatalogClassNode;
import team.weiyu.culture.model.CatalogInstanceNode;

public interface CatalogService {

	ArrayList<CatalogClassNode> getHierarchyRootClasses();
	
	ArrayList<CatalogClassNode> getSubClasses(String className);
	
	ArrayList<CatalogInstanceNode> getInstances(String className);
}

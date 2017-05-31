package team.weiyu.culture.dao;

import java.util.ArrayList;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;

public interface CatalogDao {

	ArrayList<String> getHierarchyRootClasses();
	
	ArrayList<String> getSubClasses(String className);
	
	ArrayList<OntResource> getInstances(OntClass ontClass);
	
	OntClass getOntClass(String className);
}

package team.weiyu.culture.serviceImpl;

import java.util.ArrayList;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;

import team.weiyu.culture.daoImpl.CatalogDaoImpl;
import team.weiyu.culture.listener.WebContextListener;
import team.weiyu.culture.model.CatalogClassNode;
import team.weiyu.culture.model.CatalogInstanceNode;
import team.weiyu.culture.service.CatalogService;
import team.weiyu.culture.util.SortTime;

public class CatalogServiceImpl implements CatalogService {

	@Override
	public ArrayList<CatalogClassNode> getHierarchyRootClasses() {
		// TODO Auto-generated method stub
		
		CatalogDaoImpl catalog = new CatalogDaoImpl();
	    ArrayList<String> classURIs = catalog.getHierarchyRootClasses();
		ArrayList<CatalogClassNode> rootClassNodes = formatAsCatalogClassNode(classURIs);
		
		return rootClassNodes;
	}

	@Override
	public ArrayList<CatalogClassNode> getSubClasses(String className) {
		// TODO Auto-generated method stub
		CatalogDaoImpl catalog = new CatalogDaoImpl();
	    ArrayList<String> subClassURIs = catalog.getSubClasses(className);
		ArrayList<CatalogClassNode> subClassNodes = formatAsCatalogClassNode(subClassURIs);
		return subClassNodes;
	}

	@Override
	public ArrayList<CatalogInstanceNode> getInstances(String className) {
		// TODO Auto-generated method stub
		
		CatalogDaoImpl catalog = new CatalogDaoImpl();
		OntClass ontClass = catalog.getOntClass(className);
		ArrayList<OntResource> instances = catalog.getInstances(ontClass);
		ArrayList<CatalogInstanceNode> instanceNodes = formatAsCatalogInstanceNode(instances);
		
		
		return instanceNodes;
	}
	
	
	private ArrayList<CatalogClassNode> formatAsCatalogClassNode(ArrayList<String> classURIs){
		ArrayList<CatalogClassNode> classNodes = new ArrayList<CatalogClassNode>();
		CatalogClassNode classNode;
		for(String classURI : classURIs){
			OntClass ontClass = WebContextListener.public_ontModel.getOntClass(classURI);
			if(ontClass!=null){
				if(ontClass.hasSubClass()){
					classNode = new CatalogClassNode(ontClass.getLocalName(),null,"",0,"","true");
				}else{
					classNode = new CatalogClassNode(ontClass.getLocalName(),null,"",0,"","false");
				}
				classNodes.add(classNode);
			}
			
		}
		return classNodes;
	}
	
	private ArrayList<CatalogInstanceNode> formatAsCatalogInstanceNode(ArrayList<OntResource> instances){
		
		ArrayList<CatalogInstanceNode> instanceNodes = new ArrayList<CatalogInstanceNode>();
		if(instances.size()!=0){
			if(instances.get(0).getURI().contains("http://www.owl-ontologies.com/Time.owl#")){
				SortTime.sortTime(instances);
			}
			for(OntResource instance : instances){
				String name = "";
				if(instance.getURI().contains("http://www.owl-ontologies.com/Time.owl#")){
					name = instance.getLocalName().substring(1) + "年";
				}else{
					name = instance.getLocalName();
				}
				CatalogInstanceNode instanceNode = new CatalogInstanceNode(name,null,"",0,"");
				instanceNodes.add(instanceNode);
			}
		}
		return instanceNodes;
	}

}

package team.weiyu.culture.daoImpl;

import java.util.ArrayList;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.util.iterator.ExtendedIterator;
import team.weiyu.culture.dao.CatalogDao;
import team.weiyu.culture.listener.WebContextListener;

public class CatalogDaoImpl implements CatalogDao{
	
	private final String[] URIS =
		   {   
			"http://www.w3.org/2002/07/owl#",
			"http://protege.stanford.edu/plugins/owl/protege#",
			"http://www.w3.org/1999/02/22-rdf-syntax-ns#",
			"http://www.w3.org/2000/01/rdf-schema#",
			"http://sqwrl.stanford.edu/ontologies/built-ins/3.4/sqwrl.owl#",
			"http://www.w3.org/2003/11/swrl#",
			"http://swrl.stanford.edu/ontologies/3.3/swrla.owl#",
			"http://www.w3.org/2003/11/swrlb#",
			"http://www.w3.org/2001/XMLSchema#",
			"http://www.owl-ontologies.com/2005/08/07/xsp.owl#",
			"http://www.w3.org/1999/02/22-rdf-syntax-ns#",
			"http://www.owl-ontologies.com/XiangshanOnto.owl#",
			"http://www.owl-ontologies.com/Individual.owl#",
			"http://www.owl-ontologies.com/Event.owl#",
			"http://www.owl-ontologies.com/Location.owl#",
			"http://www.owl-ontologies.com/Think.owl#",
			"http://www.owl-ontologies.com/Relics.owl#",
			"http://www.owl-ontologies.com/Localism.owl#",
			"http://www.owl-ontologies.com/Time.owl#",
			"http://www.owl-ontologies.com/Folk.owl#",
			"http://www.owl-ontologies.com/Organization.owl#",
			"http://www.owl-ontologies.com/Duty_Title.owl#",
			"http://www.owl-ontologies.com/Art.owl#",			   
			};
	
	@Override
	public OntClass getOntClass(String className){
		OntClass ontClass = null;
		for(String uri : URIS){
			ontClass = WebContextListener.public_ontModel.getOntClass(uri+className);	
			if(ontClass!=null) {			
				return ontClass;
			}
		}
		return ontClass;
	}

	@Override
	public ArrayList<String> getHierarchyRootClasses() {
		// TODO Auto-generated method stub
		ArrayList<String> classURIs = new ArrayList<String>();
		ExtendedIterator<OntClass> iterator = WebContextListener.public_ontModel.listHierarchyRootClasses();

		while(iterator.hasNext()){
			OntClass ontClass = iterator.next();
			if(!ontClass.isAnon()){
				classURIs.add(ontClass.getURI());
			}
		}
		
		iterator.close();
		
		return classURIs;
	}

	@Override
	public ArrayList<String> getSubClasses(String className) {
		// TODO Auto-generated method stub	
		OntClass ontClass = getOntClass(className);
		ArrayList<String> subClassURIs = new ArrayList<String>();
		if(ontClass!=null&&ontClass.hasSubClass()){
			ExtendedIterator<OntClass> iterator = ontClass.listSubClasses();
			while(iterator.hasNext()){
				OntClass subClass = iterator.next();
				if(!subClass.isAnon()){
					subClassURIs.add(subClass.getURI());
				}
			}
			
			iterator.close();
		}
		return subClassURIs;
	}
	
	@Override
	public ArrayList<OntResource> getInstances(OntClass ontClass){
		ArrayList<OntResource> instances = new ArrayList<OntResource>();
		ExtendedIterator<? extends OntResource> iterator = ontClass.listInstances();
		while(iterator.hasNext()){
			OntResource instance = iterator.next();
			instances.add(instance);
		}
		
		iterator.close();
		
		return instances;
		
	}
	
}

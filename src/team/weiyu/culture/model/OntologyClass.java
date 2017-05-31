package team.weiyu.culture.model;

import org.apache.jena.ontology.OntClass;

public class OntologyClass {

	private OntClass ontClass;
	private boolean hasSubClass;
	private boolean hasInstance;
	public OntologyClass(OntClass ontClass, boolean hasSubClass, boolean hasInstance) {
		super();
		this.ontClass = ontClass;
		this.hasSubClass = hasSubClass;
		this.hasInstance = hasInstance;
	}
	public OntClass getOntClass() {
		return ontClass;
	}
	public void setOntClass(OntClass ontClass) {
		this.ontClass = ontClass;
	}
	public boolean hasSubClass() {
		return hasSubClass;
	}
	public void setHasSubClass(boolean hasSubClass) {
		this.hasSubClass = hasSubClass;
	}
	public boolean hasInstance() {
		return hasInstance;
	}
	public void setHasInstance(boolean hasInstance) {
		this.hasInstance = hasInstance;
	}
	
}

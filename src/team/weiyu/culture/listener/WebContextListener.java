package team.weiyu.culture.listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.tdb.TDBFactory;

import team.weiyu.culture.model.CatalogClassNode;
import team.weiyu.culture.serviceImpl.CatalogServiceImpl;
import team.weiyu.culture.util.OntDocumentManagerProcess;

/**
 * Application Lifecycle Listener implementation class WebContextListener
 *
 */
@WebListener
public class WebContextListener implements ServletContextListener {

	public static Dataset public_dataset = null;
	public static OntModel public_ontModel = null;
	public static Model public_model = null;
	public static String WebRoot = "";
	public static final String NAMED_GRAPH_URI = "http://www.owl-ontologies.com/";
	
    /**
     * Default constructor. 
     */
    public WebContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	if(public_model!=null) {
    		public_model.close();
    	}
    	if(public_dataset!=null) {
    		public_dataset.close();
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	WebRoot = sce.getServletContext().getRealPath("");
    	public_dataset = TDBFactory.createDataset(WebRoot+"culture_tdb");
    	public_model = public_dataset.getNamedModel(WebContextListener.NAMED_GRAPH_URI+"culture_7.0_whole");
    	public_ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
    	OntDocumentManager dm = public_ontModel.getDocumentManager();
    	OntDocumentManagerProcess.addAltEntries(dm);
    	public_ontModel.read("http://www.owl-ontologies.com/XiangshanOnto.owl");
    	
		CatalogServiceImpl catalog = new CatalogServiceImpl();
    	ArrayList<CatalogClassNode> topClasses = catalog.getHierarchyRootClasses();
    	sce.getServletContext().setAttribute("topClasses", topClasses);
    	
    }
   
}

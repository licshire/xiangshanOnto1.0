package team.weiyu.culture.util;

import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.tdb.TDBFactory;

import team.weiyu.culture.listener.WebContextListener;

public class CreateTDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dataset ds = TDBFactory.createDataset("WebContent\\culture_tdb"); //创建名为"culture_tdb"的数据集
		 
		OntModel model=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM); //创建本体模型
		
		OntDocumentManager dm = model.getDocumentManager();
		
		OntDocumentManagerProcess.addAltEntries(dm);
		
		model.read("http://www.owl-ontologies.com/XiangshanOnto.owl");
		
		ds.addNamedModel(WebContextListener.NAMED_GRAPH_URI+"culture_7.0_now", model);
		
		model.close();   //关闭模型和 Dataset 
		
		ds.close(); 
		
		System.out.println("创建成功!");
	}

}

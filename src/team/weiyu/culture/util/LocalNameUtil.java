package team.weiyu.culture.util;

import org.apache.jena.rdf.model.RDFNode;

public class LocalNameUtil {

	public static String getRDFNodeLocalName(RDFNode node){
		String localName;
		if(node!=null&&!node.isAnon()){
			if(node.isResource()){
				localName = node.asResource().getLocalName();
			}else{
				localName = node.toString();
			}
		}else{
			return " ";
		}
		
		return localName;
	}
}

package team.weiyu.culture.util;

import java.util.HashMap;

import org.apache.jena.rdf.model.RDFNode;

public class GetDefaultImgUtil {

	private static final HashMap<String,String> IMG_MAP = new HashMap<String,String>();
	
	static{
		IMG_MAP.put("http://www.owl-ontologies.com/Individual.owl#", "Individual");
		IMG_MAP.put("http://www.owl-ontologies.com/Event.owl#", "Event");
		IMG_MAP.put("http://www.owl-ontologies.com/Location.owl#", "Location");
		IMG_MAP.put("http://www.owl-ontologies.com/Think.owl#", "Think");
		IMG_MAP.put("http://www.owl-ontologies.com/Relics.owl#", "Relics");
		IMG_MAP.put("http://www.owl-ontologies.com/Localism.owl#", "Localism");
		IMG_MAP.put("http://www.owl-ontologies.com/Time.owl#", "Time");
		IMG_MAP.put("http://www.owl-ontologies.com/Folk.owl#", "Folk");
		IMG_MAP.put("http://www.owl-ontologies.com/Organization.owl#", "Organization");
		IMG_MAP.put("http://www.owl-ontologies.com/Duty_Title.owl#", "Duty_Title");
		IMG_MAP.put("http://www.owl-ontologies.com/Art.owl#", "Art");
		
	}
	
	public static String getDefaultImg(RDFNode node){
		String defaultImg;
		if(node.isResource()){
			String uri = node.asResource().getURI();
			uri = uri.substring(0,uri.indexOf("#")+1);
			defaultImg = IMG_MAP.get(uri);
		}else{
			defaultImg = "Literal";
		}
		return defaultImg;
	}
}

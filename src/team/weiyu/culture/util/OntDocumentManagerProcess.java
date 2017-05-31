package team.weiyu.culture.util;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.jena.ontology.OntDocumentManager;

import team.weiyu.culture.listener.WebContextListener;

public class OntDocumentManagerProcess {

	private final static HashMap<String,String> ALT_ENTRY_MAP = new HashMap<String,String>();
	
	static{
		
		String path = "";
		if(!WebContextListener.WebRoot.equals("")){
			path = WebContextListener.WebRoot;
		}else{
			path = "WebContent/";
		}
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/XiangshanOnto.owl","file:"+path+"owl/XiangshanOnto.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Art.owl","file:"+path+"owl/Art.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Duty_Title.owl","file:"+path+"owl/Duty_Title.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Event.owl","file:"+path+"owl/Event.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Folk.owl","file:"+path+"owl/Folk.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Individual.owl","file:"+path+"owl/Individual.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Localism.owl","file:"+path+"owl/Localism.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Location.owl","file:"+path+"owl/Location.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Organization.owl","file:"+path+"owl/Organization.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Relics.owl","file:"+path+"owl/Relics.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Think.owl","file:"+path+"owl/Think.owl" );
		
		ALT_ENTRY_MAP.put( "http://www.owl-ontologies.com/Time.owl","file:"+path+"owl/Time.owl" );
	}
	
	public static void addAltEntries(OntDocumentManager dm){
		
		Iterator<String> iterator = ALT_ENTRY_MAP.keySet().iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			dm.addAltEntry(key, ALT_ENTRY_MAP.get(key));
		}
	}
}

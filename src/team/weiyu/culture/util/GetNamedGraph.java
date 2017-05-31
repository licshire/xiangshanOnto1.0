package team.weiyu.culture.util;

import java.util.HashMap;

public class GetNamedGraph {

	public static final HashMap<String,String> GRAPH_MAP = new HashMap<String,String>();
	
	static{
		GRAPH_MAP.put("古", " namedGraph:culture_7.0_past ");
		GRAPH_MAP.put("今", " namedGraph:culture_7.0_now ");
		GRAPH_MAP.put("全", " namedGraph:culture_7.0_whole ");
	}
}

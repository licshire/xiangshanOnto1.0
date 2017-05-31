package team.weiyu.culture.util;

import team.weiyu.culture.listener.WebContextListener;

public class Prefix {

	public static final String PREFIXS =

			"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
			"PREFIX protege: <http://protege.stanford.edu/plugins/owl/protege#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
			"PREFIX sqwrl: <http://sqwrl.stanford.edu/ontologies/built-ins/3.4/sqwrl.owl#>"+
			"PREFIX swrl: <http://www.w3.org/2003/11/swrl#>"+
			"PREFIX swrla: <http://swrl.stanford.edu/ontologies/3.3/swrla.owl#>"+
			"PREFIX swrlb: <http://www.w3.org/2003/11/swrlb#>"+
			"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
			"PREFIX xsp: <http://www.owl-ontologies.com/2005/08/07/xsp.owl#>"+
			"PREFIX root: <http://www.owl-ontologies.com/XiangshanOnto.owl#>"+
		    "PREFIX 人物: <http://www.owl-ontologies.com/Individual.owl#>"+
		    "PREFIX 历史事件: <http://www.owl-ontologies.com/Event.owl#>"+
		    "PREFIX 地点: <http://www.owl-ontologies.com/Location.owl#>"+
		    "PREFIX 思想精神文化: <http://www.owl-ontologies.com/Think.owl#>"+
		    "PREFIX 文化遗存: <http://www.owl-ontologies.com/Relics.owl#>"+
		    "PREFIX 方言: <http://www.owl-ontologies.com/Localism.owl#>"+
		    "PREFIX 时间: <http://www.owl-ontologies.com/Time.owl#>"+
		    "PREFIX 民俗: <http://www.owl-ontologies.com/Folk.owl#>"+
		    "PREFIX 组织机构: <http://www.owl-ontologies.com/Organization.owl#>"+
		    "PREFIX 职务和称号: <http://www.owl-ontologies.com/Duty_Title.owl#>"+
		    "PREFIX 艺术: <http://www.owl-ontologies.com/Art.owl#>"+
		    "PREFIX namedGraph: <"+WebContextListener.NAMED_GRAPH_URI+">";	
}

package team.weiyu.culture.util;

import java.util.HashMap;

public class PredicateFormatter {

	private static final HashMap<String,String> PREDICATE_MAP = new HashMap<String,String>();
	
	static{
		PREDICATE_MAP.put("type", "父类");
		PREDICATE_MAP.put("subClassOf", "父类");
		PREDICATE_MAP.put("comment", "详细信息");
	}
	
	public static String getFormattedPredicate(String predicate){
		if(PREDICATE_MAP.get(predicate)!=null){
			return PREDICATE_MAP.get(predicate);
		}else{
			return predicate;
		}
	}
}

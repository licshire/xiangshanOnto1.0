package team.weiyu.culture.util;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import team.weiyu.culture.model.CatalogClassNode;
import team.weiyu.culture.model.CatalogInstanceNode;
import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;

public class FormatAsJson {

	public static String formatAsJson(Object object) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		result = mapper.writeValueAsString(object);
		
		return result;
	}
	
	public static String formatAsJson(ArrayList<CatalogClassNode> classNodes, ArrayList<CatalogInstanceNode> instanceNodes) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		if(classNodes!=null){
			result = mapper.writeValueAsString(classNodes);
		}else{
			result = mapper.writeValueAsString(instanceNodes);
		}
		
		return result;
	};
	
	public static String formatAsJson(ArrayList<TripleObject> objects) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		result = mapper.writeValueAsString(objects);
		
		return result;
	}
	
	public static String formatAsJson(QueryResult queryResult) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		result = mapper.writeValueAsString(queryResult);
		
		return result;
	}
	
	public static String formatStringsAsJson(ArrayList<String> predicates) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		String result = "";
		
		result = mapper.writeValueAsString(predicates);
		
		return result;
	}
}

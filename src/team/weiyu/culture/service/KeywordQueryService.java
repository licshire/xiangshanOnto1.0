package team.weiyu.culture.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import team.weiyu.culture.model.DetailNode;
import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;

public interface KeywordQueryService {

	ArrayList<QueryResult> query(TripleObject tripleObject,String scope);
	
	LinkedHashSet<String> indistinctQuery(TripleObject tripleObject,String scope);
	
	DetailNode getDetails(TripleObject tripleObject);
}

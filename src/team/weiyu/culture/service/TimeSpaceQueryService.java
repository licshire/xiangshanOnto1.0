package team.weiyu.culture.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;

public interface TimeSpaceQueryService {

	ArrayList<QueryResult> query(TripleObject object , String scope);
	
	LinkedHashSet<String> indistinctQuery(TripleObject tripleObject,String scope);
}

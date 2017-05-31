package team.weiyu.culture.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import team.weiyu.culture.model.TripleObject;

public interface PredicateService {

	ArrayList<TripleObject> query(TripleObject tripleObject);
	
	LinkedHashSet<String> indistinctQuery(TripleObject tripleObject);
	
	ArrayList<String> getPredicates();
}

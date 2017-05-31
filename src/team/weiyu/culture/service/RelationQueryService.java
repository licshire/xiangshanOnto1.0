package team.weiyu.culture.service;

import java.util.HashSet;

import team.weiyu.culture.model.TripleObject;

public interface RelationQueryService {

	HashSet<String> query(TripleObject tripleObject);
	
}

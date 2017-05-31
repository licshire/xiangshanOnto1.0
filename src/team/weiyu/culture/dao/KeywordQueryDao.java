package team.weiyu.culture.dao;

import org.apache.jena.query.ResultSet;

import team.weiyu.culture.model.TripleObject;

public interface KeywordQueryDao {

	ResultSet query(TripleObject object,String scope);
	
	ResultSet queryDetail(TripleObject object);
}

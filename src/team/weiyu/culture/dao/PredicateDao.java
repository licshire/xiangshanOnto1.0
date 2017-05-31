package team.weiyu.culture.dao;

import org.apache.jena.query.ResultSet;

import team.weiyu.culture.model.TripleObject;

public interface PredicateDao {

	ResultSet query(TripleObject object);
	
	ResultSet indistinctQuery(TripleObject object);
	
	ResultSet getPredicates();
}

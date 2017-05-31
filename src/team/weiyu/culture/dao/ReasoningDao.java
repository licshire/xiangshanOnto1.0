package team.weiyu.culture.dao;

import org.apache.jena.query.ResultSet;

import team.weiyu.culture.model.TripleObject;

public interface ReasoningDao {

	ResultSet reasoning(TripleObject object);
}

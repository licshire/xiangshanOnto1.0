package team.weiyu.culture.dao;

import org.apache.jena.query.ResultSet;

import team.weiyu.culture.model.TripleObject;

public interface RelationQueryDao {

	ResultSet query(TripleObject object);
}

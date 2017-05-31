package team.weiyu.culture.daoImpl;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

import team.weiyu.culture.dao.KeywordQueryDao;
import team.weiyu.culture.listener.WebContextListener;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.util.GetClassURI;
import team.weiyu.culture.util.Prefix;

public class KeywordQueryDaoImpl implements KeywordQueryDao{

	@Override
	public ResultSet query(TripleObject object,String scope) {
		// TODO Auto-generated method stub
		String classUri = "";
		if(!scope.equals("所有类")){
			classUri = GetClassURI.CLASS_URI.get(scope);
		}
		System.out.println("classUri:"+classUri);
		String queryString = 
				Prefix.PREFIXS+
				"SELECT DISTINCT ?subject ?predicate ?object " 
				+"WHERE {" 
				+" {?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+object.getSubject()+"')."
				+ " FILTER (regex(str(?subject), '"+classUri+"'))."
				+ " FILTER (regex(str(?object), '"+classUri+"')).}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?object),'"+object.getObject()+"')."
				+ " FILTER (regex(str(?object), '"+classUri+"'))."
				+ " FILTER (regex(str(?subject), '"+classUri+"')).}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+object.getObject()+"')."
				+ " FILTER (!regex(str(?object), '"+object.getObject()+"'))."
				+ " FILTER (regex(str(?object), '"+classUri+"'))."
				+ " FILTER (!regex(str(?subject), '"+classUri+"')).}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?object),'"+object.getObject()+"')."
				+ " FILTER (!regex(str(?object), '"+classUri+"'))."
				+ " FILTER (regex(str(?subject), '"+classUri+"'))."
				+ " FILTER (regex(str(?predicate), '"+classUri+"')).}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?object),'"+object.getObject()+"')."
				+ " FILTER (!regex(str(?subject), '"+object.getObject()+"'))."
				+ " FILTER (regex(str(?subject), '"+classUri+"')).}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+object.getObject()+"')."
				+ " FILTER (regex(str(?subject), '"+classUri+"'))."
				+ " FILTER (regex(str(?predicate), 'comment')).}"
				+ "}";
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_model);
		
		ResultSet results= qe.execSelect();
		return results;
	}

	@Override
	public ResultSet queryDetail(TripleObject object) {
		// TODO Auto-generated method stub
		String queryString = 
				Prefix.PREFIXS+
				"SELECT ?subject ?predicate ?object " +
				"WHERE {" +
				" {?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+object.getSubject()+"').}"
				+ "}";
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_model);
		
		ResultSet results= qe.execSelect();
		return results;
	}
}

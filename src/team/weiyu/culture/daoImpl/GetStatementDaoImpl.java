package team.weiyu.culture.daoImpl;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

import team.weiyu.culture.dao.GetStatementDao;
import team.weiyu.culture.listener.WebContextListener;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.util.Prefix;

public class GetStatementDaoImpl implements GetStatementDao{

	@Override
	public ResultSet query(TripleObject object) {
		// TODO Auto-generated method stub
		String queryString = 
				Prefix.PREFIXS+
				"SELECT DISTINCT ?subject ?predicate ?object " 
				+"WHERE {" 
				+" {?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+object.getSubject()+"')."
				+ " FILTER (regex(str(?object), '"+object.getObject()+"')).}"
				+ "}";
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_model);
		
		ResultSet results= qe.execSelect();
		
		return results;
	}

}

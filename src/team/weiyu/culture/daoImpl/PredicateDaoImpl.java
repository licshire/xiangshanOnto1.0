package team.weiyu.culture.daoImpl;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

import team.weiyu.culture.dao.PredicateDao;
import team.weiyu.culture.listener.WebContextListener;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.util.Prefix;

public class PredicateDaoImpl implements PredicateDao {

	@Override
	public ResultSet query(TripleObject object) {
		// TODO Auto-generated method stub
		
		String queryString = 
				Prefix.PREFIXS +
				"SELECT ?subject ?predicate ?object " +
				"WHERE {" 
				+"  ?subject ?predicate ?object."
				+ "	FILTER (regex(str(?predicate), '"+object.getPredicate()+"')).}";;
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_model);
		
		ResultSet results= qe.execSelect();
		
		return results;
	}
	
	@Override
	public ResultSet indistinctQuery(TripleObject object) {
		// TODO Auto-generated method stub
		String queryString = 
				Prefix.PREFIXS+
				"SELECT DISTINCT ?predicate " 
				+"WHERE {" 
				+" {?subject ?predicate ?object."
				+ "FILTER regex(str(?predicate),'"+object.getPredicate()+"')."
				+ " FILTER (!regex(str(?predicate), 'rdf'))."
				+ " FILTER (!regex(str(?predicate), 'imports'))."
				+ "	FILTER (!regex(str(?predicate), 'versionInfo'))."
				+ "	FILTER (!regex(str(?predicate), 'oneOf'))."
				+ "	FILTER (!regex(str(?predicate), 'unionOf'))."
				+ "	FILTER (!regex(str(?predicate), 'inverseOf')).}"
				+ "}";
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_model);
		
		ResultSet results= qe.execSelect();
		
		return results;
	}

	@Override
	public ResultSet getPredicates() {
		// TODO Auto-generated method stub
		String queryString = 
				Prefix.PREFIXS +
				"SELECT DISTINCT ?predicate " +
				"WHERE {" +
				"  ?subject ?predicate ?object."
				+ " FILTER (!regex(str(?predicate), 'rdf'))."
				+ " FILTER (!regex(str(?predicate), 'imports'))."
				+ "	FILTER (!regex(str(?predicate), 'versionInfo'))."
				+ "	FILTER (!regex(str(?predicate), 'oneOf'))."
				+ "	FILTER (!regex(str(?predicate), 'unionOf'))."
				+ "	FILTER (!regex(str(?predicate), 'inverseOf')).}";
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_model);
		
		ResultSet results= qe.execSelect();
		
		return results;
	}

}

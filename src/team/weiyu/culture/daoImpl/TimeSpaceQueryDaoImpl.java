package team.weiyu.culture.daoImpl;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

import team.weiyu.culture.dao.TimeSpaceQueryDao;
import team.weiyu.culture.listener.WebContextListener;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.util.GetNamedGraph;
import team.weiyu.culture.util.Prefix;

public class TimeSpaceQueryDaoImpl implements TimeSpaceQueryDao{
	
	@Override
	public ResultSet query(TripleObject object, String scope) {
		// TODO Auto-generated method stub
		String namedGraph = GetNamedGraph.GRAPH_MAP.get(scope);
		String queryString = 
				Prefix.PREFIXS
				+"SELECT DISTINCT ?subject ?predicate ?object "
				+"FROM "
				+namedGraph
				+"WHERE {" 
				+ "{?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+object.getSubject()+"').}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?object),'"+object.getObject()+"').}"
				+ "}"; 
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_dataset);
		
		ResultSet results= qe.execSelect();
		
		return results;
			
	}

}

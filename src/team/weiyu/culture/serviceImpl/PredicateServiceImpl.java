package team.weiyu.culture.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import team.weiyu.culture.daoImpl.PredicateDaoImpl;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.service.PredicateService;
import team.weiyu.culture.util.LocalNameUtil;
import team.weiyu.culture.util.ResultSetProcessUtil;

public class PredicateServiceImpl implements PredicateService{

	@Override
	public ArrayList<TripleObject> query(TripleObject tripleObject) {
		// TODO Auto-generated method stub
		PredicateDaoImpl predicateDao = new PredicateDaoImpl();
		ResultSet resultSet = predicateDao.query(tripleObject);
		ArrayList<TripleObject> result=new ArrayList<TripleObject>();
		result = ResultSetProcessUtil.processResultSetAsTripleObjects(tripleObject, resultSet);
		return result;
	}
	
	

	@Override
	public ArrayList<String> getPredicates() {
		// TODO Auto-generated method stub
		ArrayList<String> predicates = new ArrayList<String>();
		PredicateDaoImpl predicateDao = new PredicateDaoImpl();
		ResultSet resultSet = predicateDao.getPredicates();
		
		while(resultSet.hasNext()){
			QuerySolution temp = resultSet.next();
			RDFNode predicateNode = temp.get("predicate");
			String predicate = LocalNameUtil.getRDFNodeLocalName(predicateNode);
			predicates.add(predicate);
		}
		return predicates;
	}



	@Override
	public LinkedHashSet<String> indistinctQuery(TripleObject tripleObject) {
		// TODO Auto-generated method stub
		PredicateDaoImpl predicateDao = new PredicateDaoImpl();
		ResultSet queryResult = predicateDao.indistinctQuery(tripleObject);
		LinkedHashSet<String> results = ResultSetProcessUtil.processPredicatesAsStrings(tripleObject, queryResult);
		
		return results;
	}

}

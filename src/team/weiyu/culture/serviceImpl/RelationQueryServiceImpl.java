package team.weiyu.culture.serviceImpl;

import java.util.HashSet;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import team.weiyu.culture.daoImpl.RelationQueryDaoImpl;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.service.RelationQueryService;
import team.weiyu.culture.util.LocalNameUtil;

public class RelationQueryServiceImpl implements RelationQueryService{

	@Override
	public HashSet<String> query(TripleObject tripleObject) {
		// TODO Auto-generated method stub
		RelationQueryDaoImpl relationQuery = new RelationQueryDaoImpl();
		ResultSet resultSet = relationQuery.query(tripleObject);
		HashSet<String> queryResult = processResultSet(tripleObject,resultSet);
		
		return queryResult;
	}
	
	private HashSet<String> processResultSet(TripleObject tripleObject,ResultSet resultSet){
		
		HashSet<String> predicates = new HashSet<String>();
		
		String subject = "";
		String predicate = "";
		String object = "";
		while(resultSet.hasNext()){
			
			QuerySolution temp = resultSet.nextSolution();
			RDFNode subjectNode = temp.get("subject");
			RDFNode predicateNode = temp.get("predicate");
			RDFNode objectNode = temp.get("object");
			
			subject = LocalNameUtil.getRDFNodeLocalName(subjectNode);
			predicate = LocalNameUtil.getRDFNodeLocalName(predicateNode);
			object = LocalNameUtil.getRDFNodeLocalName(objectNode);
			
			if(subject.equals(tripleObject.getSubject())&&object.equals(tripleObject.getObject())){
				predicates.add(predicate);
			}else if(subject.equals(tripleObject.getObject())&&object.equals(tripleObject.getSubject())){
				predicates.add(predicate);
			}
			
		}
		
		return predicates;
	}

}

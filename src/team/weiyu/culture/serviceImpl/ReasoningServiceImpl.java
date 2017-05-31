package team.weiyu.culture.serviceImpl;

import java.util.ArrayList;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import team.weiyu.culture.daoImpl.ReasoningDaoImpl;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.service.ReasoningService;

public class ReasoningServiceImpl implements ReasoningService{

	@Override
	public ArrayList<TripleObject> reasoning(TripleObject tripleObject) {
		// TODO Auto-generated method stub
		ReasoningDaoImpl reasoner = new ReasoningDaoImpl();
		ResultSet resultSet = reasoner.reasoning(tripleObject);
		ArrayList<TripleObject> reasoningResult = processResultSet(tripleObject,resultSet);
		return reasoningResult;
	}
	
	private ArrayList<TripleObject> processResultSet(TripleObject tripleObject,ResultSet resultSet){
		
		ArrayList<TripleObject> tripleObjects = new ArrayList<TripleObject>();
		
		String subject = "";
		String predicate = "";
		String object = "";
		
		while(resultSet.hasNext()){
			QuerySolution temp = resultSet.nextSolution();
			RDFNode subjectNode = temp.get("subject");
			RDFNode predicateNode = temp.get("predicate");
			RDFNode objectNode = temp.get("object");
			if(subjectNode.isResource()&&predicateNode.isResource()&&objectNode.isResource()){
				subject = subjectNode.asResource().getLocalName();
				predicate = predicateNode.asResource().getLocalName();
				object = objectNode.asResource().getLocalName();
			}else if(subjectNode.isResource()&&predicateNode.isResource()&&objectNode.isLiteral()){
				subject = subjectNode.asResource().getLocalName();
				predicate = predicateNode.asResource().getLocalName();
				object = objectNode.toString();
			}else if(subjectNode.isResource()&&predicateNode.isLiteral()&&objectNode.isResource()){
				subject = subjectNode.asResource().getLocalName();
				predicate = predicateNode.toString();
				object = objectNode.asResource().getLocalName();
			}else if(subjectNode.isResource()&&predicateNode.isLiteral()&&objectNode.isLiteral()){
				subject = subjectNode.asResource().getLocalName();
				predicate = predicateNode.toString();
				object = objectNode.toString();
			}else{
				subject = subjectNode.toString();
				predicate = predicateNode.toString();
				object = objectNode.toString();					
			}
			System.out.println(subject+predicate+object);
			if(!(subject.equals(""))){
				TripleObject ob = new TripleObject(subject,predicate,object);
				tripleObjects.add(ob);
			}
		}
		
		return tripleObjects;
	}

}

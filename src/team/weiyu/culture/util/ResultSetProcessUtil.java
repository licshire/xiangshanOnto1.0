package team.weiyu.culture.util;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import team.weiyu.culture.listener.WebContextListener;
import team.weiyu.culture.model.DetailNode;
import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;

public class ResultSetProcessUtil {

	private static QueryResult processSolutionAsQueryResultNode(QuerySolution solution){
		
		QueryResult queryResult = null;

		RDFNode subjectNode = solution.get("subject");
		RDFNode predicateNode = solution.get("predicate");
		RDFNode objectNode = solution.get("object");
		
		String subject = LocalNameUtil.getRDFNodeLocalName(subjectNode);
		String predicate = LocalNameUtil.getRDFNodeLocalName(predicateNode);
		String object = LocalNameUtil.getRDFNodeLocalName(objectNode);
		
		String subjectDefaultImg = GetDefaultImgUtil.getDefaultImg(subjectNode);
		String objectDefaultImg = GetDefaultImgUtil.getDefaultImg(objectNode);
		
		File objectImage = new File(WebContextListener.WebRoot+"images\\"+object+".jpg");
		File subjectImage = new File(WebContextListener.WebRoot+"images\\"+subject+".jpg");
		
		String objectImg= object;
		String subjectImg = subject;
		
		if(!objectImage.exists()){
			objectImg = objectDefaultImg;
		}
		if(!subjectImage.exists()){
			subjectImg = subjectDefaultImg;
		}
		
		ArrayList<QueryResult> children= new ArrayList<QueryResult>();
		
		if(subject.contains("y")||object.contains("y")){
			if(YearRegEx.isLegal(subject)){
				subject = subject.substring(1) + "年";
			}else if(YearRegEx.isLegal(object)){
				object = object.substring(1) + "年";
			}
		}
		QueryResult child = new QueryResult(object,new ArrayList<QueryResult>(),PredicateFormatter.getFormattedPredicate(predicate),0,"images/"+objectImg+".jpg");
		
		children.add(child);
		
		queryResult = new QueryResult(subject,children,"",0,"images/"+subjectImg+".jpg");
		
		return queryResult;
		
	}
	
	public static ArrayList<QueryResult> processResultSetAsQueryResultNodes(TripleObject tripleObject,ResultSet resultSet,String type){
			
		ArrayList<QueryResult> results1 = new ArrayList<QueryResult>();
		
		ArrayList<QueryResult> results2 = new ArrayList<QueryResult>();

		QueryResult queryResult = null;
		
		while(resultSet.hasNext()){
			
			QuerySolution solution = resultSet.nextSolution();
			RDFNode subjectNode = solution.get("subject");
			RDFNode predicateNode = solution.get("predicate");
			RDFNode objectNode = solution.get("object");
			
			
			String subject = LocalNameUtil.getRDFNodeLocalName(subjectNode);
			String predicate = LocalNameUtil.getRDFNodeLocalName(predicateNode);
			String object = LocalNameUtil.getRDFNodeLocalName(objectNode);
			if(type.equals("keywordQuery")||type.equals("timeSpaceQuery")){
				if(subjectNode.isResource()&&objectNode.isResource()&&!predicate.contains("type")){
					if(subject.equals(tripleObject.getSubject())||object.equals(tripleObject.getSubject())){
						queryResult = processSolutionAsQueryResultNode(solution);
						if(queryResult!=null){
							results1.add(queryResult);
						}
					}
				}
				if(predicate.contains("comment")||predicate.contains("type")){
					
					if(subject.equals(tripleObject.getSubject())||object.equals(tripleObject.getSubject())){
						queryResult = processSolutionAsQueryResultNode(solution);
						if(queryResult!=null){
							results2.add(queryResult);
						}
					}
				}
			}else if(type.equals("getStatement")){
				if(subject.equals(tripleObject.getSubject())&&object.equals(tripleObject.getObject())){
					queryResult = processSolutionAsQueryResultNode(solution);
					if(queryResult!=null){
						results1.add(queryResult);
					}
				}
			}
		
		}
		
		if(results1.size()==0&&results2.size()>0){
			results1 = results2;
		}
		
		return results1;
	}

	public static DetailNode processResultSetAsDetailNode(TripleObject tripleObject,ResultSet resultSet){
		
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
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
			
			if(predicate.contains("type")||objectNode.isLiteral()||subjectNode.isLiteral()){
				
				if(subject.equals(tripleObject.getSubject())||object.equals(tripleObject.getSubject())){
					keys.add(PredicateFormatter.getFormattedPredicate(predicate));
					if(object.contains("^^")){
						object = object.substring(0,object.indexOf("^^"));
					}else if(object.contains("@")){
						object = object.substring(0,object.indexOf("@"));
					}
					values.add(object);				
				}
					
			}
			
		}
	
		DetailNode result = new DetailNode(keys,values);
			
		return result;
	}
	
	public static ArrayList<TripleObject> processResultSetAsTripleObjects(TripleObject tripleObject,ResultSet resultSet){
		
		ArrayList<TripleObject> results = new ArrayList<TripleObject>();
		String subject = "";
		String object = "";
		String predicate = "";
		
		while(resultSet.hasNext()){
			QuerySolution temp = resultSet.nextSolution();
			RDFNode subjectNode = temp.get("subject");
			RDFNode objectNode = temp.get("object");
			RDFNode predicateNode = temp.get("predicate");
			
			subject = LocalNameUtil.getRDFNodeLocalName(subjectNode);
			object = LocalNameUtil.getRDFNodeLocalName(objectNode);
			predicate = LocalNameUtil.getRDFNodeLocalName(predicateNode);
			
			if(predicate.equals(tripleObject.getPredicate())){
				if(subject.contains("y")||object.contains("y")){
					if(YearRegEx.isLegal(subject)){
						subject = subject.substring(1) + "年";
					}else if(YearRegEx.isLegal(object)){
						object = object.substring(1) + "年";
					}
				}
				
				TripleObject ob = new TripleObject(subject,tripleObject.getPredicate(),object);
				results.add(ob);
			}
				
		}
		
		return results;
	}
	
	public static LinkedHashSet<String> processResultSetAsStrings(TripleObject tripleObject,ResultSet resultSet){
		
		LinkedHashSet<String> results = new LinkedHashSet<String>();
		String subject = "";
		String object = "";
		String predicate = "";
		while(resultSet.hasNext()){

			QuerySolution temp = resultSet.nextSolution();
			RDFNode subjectNode = temp.get("subject");
			RDFNode objectNode = temp.get("object");
			RDFNode predicateNode = temp.get("predicate");
			subject = LocalNameUtil.getRDFNodeLocalName(subjectNode);
			object = LocalNameUtil.getRDFNodeLocalName(objectNode);
			predicate = LocalNameUtil.getRDFNodeLocalName(predicateNode);

			if(!predicate.equals("range")&&!predicate.equals("domain")){

				if(subjectNode.isResource()&&!(subject.contains(".owl")||subject.equals("Class")||subject.equals("Ontology")||subject.equals("nil")||subject.equals("string")||subject.equals("DataRange")||subject.equals("QuanLouie")||subject.equals("date"))&&subject.contains(tripleObject.getSubject())){
					if(subject.contains("y")){
						if(YearRegEx.isLegal(subject)){
							subject = subject.substring(1) + "年";
						}
					}
					results.add(subject);
				}
				if(objectNode.isResource()&&!(object.contains(".owl")||object.contains("Class")||object.equals("Ontology")||object.equals("nil")||object.equals("string")||object.equals("DataRange")||object.equals("QuanLouie")||object.equals("date"))&&object.contains(tripleObject.getObject())){
					if(object.contains("y")){
						if(YearRegEx.isLegal(object)){
							object = object.substring(1) + "年";
						}
					}
					results.add(object);
				}
			}
		}

		return results;
	}
	
	public static LinkedHashSet<String> processPredicatesAsStrings(TripleObject tripleObject,ResultSet resultSet){
		
		LinkedHashSet<String> results = new LinkedHashSet<String>();
		String predicate = "";
		while(resultSet.hasNext()){
			QuerySolution temp = resultSet.nextSolution();
			RDFNode predicateNode = temp.get("predicate");
			predicate = LocalNameUtil.getRDFNodeLocalName(predicateNode);
			if(predicate.contains(tripleObject.getPredicate())){
				results.add(predicate);
			}
		}
		
		return results;
	}
}

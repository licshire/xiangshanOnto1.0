package team.weiyu.culture.daoImpl;

import java.io.File;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;

import team.weiyu.culture.dao.ReasoningDao;
import team.weiyu.culture.listener.WebContextListener;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.util.Prefix;
import team.weiyu.culture.util.RulesData;

public class ReasoningDaoImpl implements ReasoningDao{
	
	public static Model reasoningPartModel;
	public static InfModel  reasoningWholeModel;
	static{
		File fileName = new File(WebContextListener.WebRoot+"rules\\xiangshan.rules");
		List<Rule> rules = RulesData.rulesDataProcess(fileName);
		Reasoner reasoner = new GenericRuleReasoner(rules);
		reasoningWholeModel = ModelFactory.createInfModel(reasoner, WebContextListener.public_model);
		reasoningPartModel = reasoningWholeModel.getDeductionsModel();
	}

	
	@Override
	public ResultSet reasoning(TripleObject object) {
		// TODO Auto-generated method stub
		String queryString = 
				Prefix.PREFIXS+
				"SELECT ?subject ?predicate ?object " +
				"WHERE {" +
				" {?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+object.getSubject()+"').}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?object),'"+object.getObject()+"').}"
				+ "}";
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, reasoningPartModel);
		
		ResultSet results= qe.execSelect();
		
		//ResultSetFormatter.out(System.out, results, query);
		
		return results;
	}

}

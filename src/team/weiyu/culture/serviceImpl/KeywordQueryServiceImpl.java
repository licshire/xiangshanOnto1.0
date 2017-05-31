package team.weiyu.culture.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.apache.jena.query.ResultSet;

import team.weiyu.culture.daoImpl.KeywordQueryDaoImpl;
import team.weiyu.culture.model.DetailNode;
import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.service.KeywordQueryService;
import team.weiyu.culture.util.ResultSetProcessUtil;

public class KeywordQueryServiceImpl implements KeywordQueryService {

	@Override
	public ArrayList<QueryResult> query(TripleObject tripleObject,String scope) {
		// TODO Auto-generated method stub
		KeywordQueryDaoImpl keywordQuery = new KeywordQueryDaoImpl();
		ResultSet resultSet = keywordQuery.query(tripleObject,scope);
		ArrayList<QueryResult> queryResult = ResultSetProcessUtil.processResultSetAsQueryResultNodes(tripleObject, resultSet,"keywordQuery");
		return queryResult;
	}
	
	@Override
	public LinkedHashSet<String> indistinctQuery(TripleObject tripleObject,String scope) {
		// TODO Auto-generated method stub
		KeywordQueryDaoImpl keywordQuery = new KeywordQueryDaoImpl();
		ResultSet queryResult = keywordQuery.query(tripleObject,scope);
		LinkedHashSet<String> results = ResultSetProcessUtil.processResultSetAsStrings(tripleObject, queryResult);
		
		return results;
	}


	@Override
	public DetailNode getDetails(TripleObject tripleObject) {
		// TODO Auto-generated method stub
		KeywordQueryDaoImpl keywordQuery = new KeywordQueryDaoImpl();
		ResultSet resultSet = keywordQuery.queryDetail(tripleObject);
		DetailNode queryResult = ResultSetProcessUtil.processResultSetAsDetailNode(tripleObject, resultSet);
		return queryResult;
	}

}

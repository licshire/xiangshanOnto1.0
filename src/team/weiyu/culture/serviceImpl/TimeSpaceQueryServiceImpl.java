package team.weiyu.culture.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.apache.jena.query.ResultSet;

import team.weiyu.culture.daoImpl.TimeSpaceQueryDaoImpl;
import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.service.TimeSpaceQueryService;
import team.weiyu.culture.util.ResultSetProcessUtil;

public class TimeSpaceQueryServiceImpl implements TimeSpaceQueryService{

	@Override
	public ArrayList<QueryResult> query(TripleObject tripleObject, String scope) {
		// TODO Auto-generated method stub
		TimeSpaceQueryDaoImpl timeSpaceQuery = new TimeSpaceQueryDaoImpl();
		ResultSet resultSet = timeSpaceQuery.query(tripleObject, scope);
		ArrayList<QueryResult> queryResult = ResultSetProcessUtil.processResultSetAsQueryResultNodes(tripleObject, resultSet,"timeSpaceQuery");
		return queryResult;
	}
	
	@Override
	public LinkedHashSet<String> indistinctQuery(TripleObject tripleObject,String scope) {
		// TODO Auto-generated method stub
		TimeSpaceQueryDaoImpl timeSpaceQuery = new TimeSpaceQueryDaoImpl();
		ResultSet queryResult = timeSpaceQuery.query(tripleObject,scope);
		LinkedHashSet<String> results = ResultSetProcessUtil.processResultSetAsStrings(tripleObject, queryResult);
		
		return results;
	}
	
}

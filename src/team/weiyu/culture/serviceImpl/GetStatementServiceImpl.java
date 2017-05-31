package team.weiyu.culture.serviceImpl;

import java.util.ArrayList;

import org.apache.jena.query.ResultSet;

import team.weiyu.culture.daoImpl.GetStatementDaoImpl;
import team.weiyu.culture.daoImpl.KeywordQueryDaoImpl;
import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.service.GetStatementService;
import team.weiyu.culture.util.ResultSetProcessUtil;

public class GetStatementServiceImpl implements GetStatementService{

	@Override
	public ArrayList<QueryResult> getStatement(TripleObject tripleObject) {
		// TODO Auto-generated method stub
		GetStatementDaoImpl statementQuery = new GetStatementDaoImpl();
		ResultSet resultSet = statementQuery.query(tripleObject);
		ArrayList<QueryResult> queryResults = ResultSetProcessUtil.processResultSetAsQueryResultNodes(tripleObject, resultSet, "getStatement");
		return queryResults;
	}

}

package team.weiyu.culture.service;

import java.util.ArrayList;

import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;

public interface GetStatementService {

	ArrayList<QueryResult> getStatement(TripleObject obj);
}

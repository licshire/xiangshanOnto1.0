package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.model.QueryResult;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.serviceImpl.KeywordQueryServiceImpl;
import team.weiyu.culture.util.FormatAsJson;
import team.weiyu.culture.util.RemoveSameElement;
import team.weiyu.culture.util.YearRegEx;

/**
 * Servlet implementation class KeywordQueryProcess
 */
@WebServlet("/KeywordQueryProcess.do")
public class KeywordQueryProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeywordQueryProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> searchHistories = (ArrayList<String>) request.getSession().getAttribute("knowledgeSearch_Histories");
		if(searchHistories==null) searchHistories = new ArrayList<String>();
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
		System.out.println("keyword:"+keyword);
		String scope = request.getParameter("scope");
		System.out.println("scope:"+scope);
		String recordable = request.getParameter("recordable");
		if(recordable.equals("true")){
			if(searchHistories.contains(keyword+"("+scope+")")){
				searchHistories.remove(keyword+"("+scope+")");
			}
			searchHistories.add(keyword+"("+scope+")");
		}
		
		if(keyword.contains("年")){
			if(YearRegEx.isLegal(keyword)){
				keyword = "y" + keyword.substring(0, 4);
			}
		}
		
		String subject = keyword;
		String predicate = keyword;
		String object = keyword;
		TripleObject tripleObject = new TripleObject(subject,predicate,object);
		KeywordQueryServiceImpl keywordQuery = new KeywordQueryServiceImpl();
		ArrayList<QueryResult> queryResult = keywordQuery.query(tripleObject,scope);
		RemoveSameElement.removeQueryResult(queryResult);
		String result = FormatAsJson.formatAsJson(queryResult);
		
		request.getSession().setAttribute("knowledgeSearch_Histories", searchHistories);
		response.setContentType("text/javascript");
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().print(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

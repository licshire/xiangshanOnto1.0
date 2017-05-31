package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.serviceImpl.PredicateServiceImpl;
import team.weiyu.culture.util.FormatAsJson;
import team.weiyu.culture.util.RemoveSameElement;

/**
 * Servlet implementation class PredicateQueryProcess
 */
@WebServlet("/PredicateQueryProcess.do")
public class PredicateQueryProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PredicateQueryProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> searchHistories = (ArrayList<String>) request.getSession().getAttribute("predicateSearch_Histories");
		if(searchHistories==null) searchHistories = new ArrayList<String>();
		request.setCharacterEncoding("utf-8");
		String predicate = request.getParameter("predicate");
		
		if(searchHistories.contains(predicate)){
			searchHistories.remove(predicate);
		}
		searchHistories.add(predicate);
		TripleObject tripleObject = new TripleObject("",predicate,"");
		PredicateServiceImpl predicateService = new PredicateServiceImpl();
		ArrayList<TripleObject> tripleObjects = predicateService.query(tripleObject);
		RemoveSameElement.removeTripleObject(tripleObjects);
		String result = FormatAsJson.formatAsJson(tripleObjects);
		
		request.getSession().setAttribute("predicateSearch_Histories", searchHistories);
		
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
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

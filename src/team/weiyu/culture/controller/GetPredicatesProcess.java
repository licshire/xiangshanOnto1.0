package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.serviceImpl.PredicateServiceImpl;
import team.weiyu.culture.util.FormatAsJson;

/**
 * Servlet implementation class GetPredicatesProcess
 */
@WebServlet("/GetPredicatesProcess.do")
public class GetPredicatesProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPredicatesProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PredicateServiceImpl predicateService = new PredicateServiceImpl();
		ArrayList<String> predicates = predicateService.getPredicates();
		String result = FormatAsJson.formatStringsAsJson(predicates);
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

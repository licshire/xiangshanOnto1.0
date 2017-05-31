package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.util.FormatAsJson;

/**
 * Servlet implementation class GetSearchHistoriesProcess
 */
@WebServlet("/GetSearchHistoriesProcess.do")
public class GetSearchHistoriesProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSearchHistoriesProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		ArrayList<String> searchHistories = null;
		if(type.equals("knowledgeSearch")){
			searchHistories = (ArrayList<String>) request.getSession().getAttribute("knowledgeSearch_Histories");
		}else if(type.equals("relationSearch")){
			System.out.println(type);
			searchHistories = (ArrayList<String>) request.getSession().getAttribute("relationSearch_Histories");
		}else if(type.equals("predicateSearch")){
			searchHistories = (ArrayList<String>) request.getSession().getAttribute("predicateSearch_Histories");
		}else if(type.equals("timeSpaceSearch")){
			searchHistories = (ArrayList<String>) request.getSession().getAttribute("timeSpaceSearch_Histories");
		}
		
		response.setContentType("text/javascript;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(FormatAsJson.formatAsJson(searchHistories));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

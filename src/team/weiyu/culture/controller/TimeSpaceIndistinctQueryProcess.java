package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.LinkedHashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.serviceImpl.TimeSpaceQueryServiceImpl;
import team.weiyu.culture.util.FormatAsJson;
/**
 * Servlet implementation class TimeSpaceInstinctQueryProcess
 */
@WebServlet("/TimeSpaceIndistinctQueryProcess.do")
public class TimeSpaceIndistinctQueryProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeSpaceIndistinctQueryProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
		String scope = request.getParameter("scope");
		if(!keyword.equals("")){
			TripleObject tripleObject = new TripleObject(keyword,keyword,keyword);
			TimeSpaceQueryServiceImpl timeSpaceService = new TimeSpaceQueryServiceImpl();
			LinkedHashSet<String> results = timeSpaceService.indistinctQuery(tripleObject, scope);
			String queryResult = FormatAsJson.formatAsJson(results);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/javascript");
			response.getWriter().print(queryResult);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
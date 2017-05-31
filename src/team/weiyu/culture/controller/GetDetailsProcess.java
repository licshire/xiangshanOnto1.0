package team.weiyu.culture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.model.DetailNode;
import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.serviceImpl.KeywordQueryServiceImpl;
import team.weiyu.culture.util.FormatAsJson;
import team.weiyu.culture.util.YearRegEx;

/**
 * Servlet implementation class GetDetailsProcess
 */
@WebServlet("/GetDetailsProcess.do")
public class GetDetailsProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDetailsProcess() {
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
		if(keyword.contains("年")){
			if(YearRegEx.isLegal(keyword)){
				keyword = "y" + keyword.substring(0, 4);
			}
		}
		System.out.println(keyword);
		String subject = keyword;
		String predicate = keyword;
		String object = keyword;
		
		TripleObject tripleObject = new TripleObject(subject,predicate,object);
		KeywordQueryServiceImpl keywordQuery = new KeywordQueryServiceImpl();
		DetailNode details = keywordQuery.getDetails(tripleObject);
		String result = FormatAsJson.formatAsJson(details);
		
		response.setContentType("text/javascript");
		response.setCharacterEncoding("utf-8");
		System.out.println(result);
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

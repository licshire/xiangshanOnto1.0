package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.serviceImpl.ReasoningServiceImpl;
import team.weiyu.culture.util.FormatAsJson;
import team.weiyu.culture.util.YearRegEx;

/**
 * Servlet implementation class ReasoningProcess
 */
@WebServlet("/ReasoningProcess.do")
public class ReasoningProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReasoningProcess() {
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
		String subject = keyword;
		String predicate = keyword;
		String object = keyword;
		TripleObject tripleObject = new TripleObject(subject,predicate,object);
		ReasoningServiceImpl reasoner = new ReasoningServiceImpl();
		ArrayList<TripleObject> reasoningResult = reasoner.reasoning(tripleObject);
		String result = FormatAsJson.formatAsJson(reasoningResult);
		System.out.println(result);
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

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
import team.weiyu.culture.serviceImpl.GetStatementServiceImpl;
import team.weiyu.culture.util.FormatAsJson;
import team.weiyu.culture.util.YearRegEx;

/**
 * Servlet implementation class GetStatementProcess
 */
@WebServlet("/GetStatementProcess.do")
public class GetStatementProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStatementProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String object = request.getParameter("object");
		
		if(subject.contains("年")||object.contains("年")){
			if(YearRegEx.isLegal(subject)){
				subject = "y" + subject.substring(0, 4);
			}else if(YearRegEx.isLegal(object)){
				object = "y" + object.substring(0, 4);
			}
		}
		
		String predicate = request.getParameter("predicate");
		System.out.println(subject+predicate+object);
		TripleObject obj = new TripleObject(subject,predicate,object);
		GetStatementServiceImpl statementService = new GetStatementServiceImpl();
		ArrayList<QueryResult> result = statementService.getStatement(obj);
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(FormatAsJson.formatAsJson(result));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

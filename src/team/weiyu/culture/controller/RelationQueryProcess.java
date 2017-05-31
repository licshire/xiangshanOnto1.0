package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.model.TripleObject;
import team.weiyu.culture.serviceImpl.RelationQueryServiceImpl;
import team.weiyu.culture.util.FormatAsJson;
import team.weiyu.culture.util.YearRegEx;

/**
 * Servlet implementation class RelationQueryProcess
 */
@WebServlet("/RelationQueryProcess.do")
public class RelationQueryProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelationQueryProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> searchHistories = (ArrayList<String>) request.getSession().getAttribute("relationSearch_Histories");
		if(searchHistories==null) searchHistories = new ArrayList<String>();
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String object = request.getParameter("object");

		if(searchHistories.contains("("+subject+","+object+")")){
			searchHistories.remove("("+subject+","+object+")");
		}
		searchHistories.add("("+subject+","+object+")");
		
		if(subject.contains("年")||object.contains("年")){
			if(YearRegEx.isLegal(subject)){
				subject = "y" + subject.substring(0, 4);
			}else if(YearRegEx.isLegal(object)){
				object = "y" + object.substring(0, 4);
			}
		}
		
		TripleObject tripleObject = new TripleObject(subject,"",object);
		RelationQueryServiceImpl relationQuery = new RelationQueryServiceImpl();
		HashSet<String>  queryResult = relationQuery.query(tripleObject);
		String result = FormatAsJson.formatAsJson(queryResult);

		request.getSession().setAttribute("relationSearch_Histories", searchHistories);
		
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

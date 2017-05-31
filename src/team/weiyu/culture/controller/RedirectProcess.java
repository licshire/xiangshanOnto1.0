package team.weiyu.culture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectProcess
 */
@WebServlet("/RedirectProcess.do")
public class RedirectProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String pageName = request.getParameter("pageName").toString();
		if(pageName.equals("relationSearch")){
			request.getRequestDispatcher("/WEB-INF/relationSearch.jsp").forward(request, response);
		}else if(pageName.equals("knowledgeSearch")){
			request.getRequestDispatcher("/WEB-INF/knowledgeSearch.jsp").forward(request, response);
		}else if(pageName.equals("showGraph")){
			request.getRequestDispatcher("/WEB-INF/showGraph.jsp").forward(request, response);
		}else if(pageName.equals("predicateSearch")){
			request.getRequestDispatcher("/WEB-INF/predicateSearch.jsp").forward(request, response);
		}else if(pageName.equals("timeSpaceSearch")){
			request.getRequestDispatcher("/WEB-INF/timeSpaceSearch.jsp").forward(request, response);
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

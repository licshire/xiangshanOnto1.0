package team.weiyu.culture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmptyHistoriesProcess
 */
@WebServlet("/EmptyHistoriesProcess.do")
public class EmptyHistoriesProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmptyHistoriesProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if(type.equals("knowledgeSearch")){
			request.getSession().setAttribute("knowledgeSearch_Histories", null);
		}else if(type.equals("relationSearch")){
			request.getSession().setAttribute("relationSearch_Histories", null);
		}else if(type.equals("predicateSearch")){
			request.getSession().setAttribute("predicateSearch_Histories", null);
		}else if(type.equals("timeSpaceSearch")){
			request.getSession().setAttribute("timeSpaceSearch_Histories", null);
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

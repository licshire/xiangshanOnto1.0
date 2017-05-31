package team.weiyu.culture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.weiyu.culture.model.CatalogClassNode;
import team.weiyu.culture.model.CatalogInstanceNode;
import team.weiyu.culture.serviceImpl.CatalogServiceImpl;
import team.weiyu.culture.util.FormatAsJson;

/**
 * Servlet implementation class CatalogProcess
 */
@WebServlet("/CatalogProcess.do")
public class CatalogProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String className = request.getParameter("name");
		CatalogServiceImpl catalog = new CatalogServiceImpl();
		ArrayList<CatalogClassNode> classNodes;
		ArrayList<CatalogInstanceNode> instanceNodes;
		String result = "";
		if(className.equals("知识分类")){
			classNodes = catalog.getHierarchyRootClasses();
			result = FormatAsJson.formatAsJson(classNodes, null);
			
		}else{
			classNodes = catalog.getSubClasses(className);
			if(classNodes.size()>0){
				result = FormatAsJson.formatAsJson(classNodes, null);
			}else{
				instanceNodes = catalog.getInstances(className);
				result = FormatAsJson.formatAsJson(null, instanceNodes);
			}
		}
		response.setContentType("text/html;charset=utf-8");
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

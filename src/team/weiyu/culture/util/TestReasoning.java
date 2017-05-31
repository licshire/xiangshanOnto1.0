package team.weiyu.culture.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.reasoner.rulesys.Rule;

import team.weiyu.culture.listener.WebContextListener;

/**
 * Servlet implementation class TestReasoning
 */
@WebServlet("/TestReasoning")
public class TestReasoning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestReasoning() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		File fileName = new File(WebContextListener.WebRoot+"rules\\xiangshan.rules");
		// 以File的形式读取rules格式的本体规则文件，若要在其中写入中文属性，则规则文件必须是UTF-8编码格式

		Model model = WebContextListener.public_model;
		
		OntoInfer oi = new OntoInfer();
		
		List<Rule> rules = RulesData.rulesDataProcess(fileName);

		Model inf = oi.Infer(model, rules);

		Iterator<?> deduct = inf.listStatements();
		// 数据迭代输出

		while (deduct.hasNext()) {

			System.out.println("--->" + deduct.next());

		}

		System.out.println("操作结束");

}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

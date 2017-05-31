package team.weiyu.culture.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import team.weiyu.culture.listener.WebContextListener;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		testSparql();
	}
	
	private void testJena(){
		
		Model ontModel = WebContextListener.public_model;
		
		StmtIterator iterator = ontModel.listStatements();
		
		while(iterator.hasNext()){
			
			Statement temp = iterator.next();
			System.out.println(temp);
		}
	}

	private void testSparql(){
		String keyword = "1";
		String namedGraph = GetNamedGraph.GRAPH_MAP.get("古");
		String queryString = 
				Prefix.PREFIXS
				+"SELECT DISTINCT ?subject ?predicate ?object "
				+"FROM "
				+namedGraph
				+"WHERE {" 
				+ "{?subject ?predicate ?object."
				+ "FILTER regex(str(?subject),'"+keyword+"').}"
				+ "UNION{?subject ?predicate ?object."
				+ "FILTER regex(str(?object),'"+keyword+"').}"
				+ "}"; 
		
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, WebContextListener.public_dataset);
		
		ResultSet results= qe.execSelect();
		
		ResultSetFormatter.out(System.out, results);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

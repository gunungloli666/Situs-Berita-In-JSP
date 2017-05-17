package page.action.mapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPage  
extends HttpServlet{	
	public void doGet(HttpServletRequest req , HttpServletResponse response){
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/jsp/AdminPage.jsp");
		try {
			 rd.forward(req  , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
}

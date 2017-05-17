package page.action.mapping;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeMapping extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/jsp/Logon.jsp");
		try {
			 rd.forward(request , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
}

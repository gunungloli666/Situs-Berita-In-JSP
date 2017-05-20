package page.action.mapping;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.ListTask;

import situs.berita.common.bean.LoginBean;
import situs.berita.common.bean.Role;
import situs.berita.common.bean.ViewArticle;

public class DoLogon extends HttpServlet {

	private LoginBean login;
	private ViewArticle viewArticle; 

	// need Dependency Injection (so there is only one instance of this class 
	// to handle everything about login)
	// but we need to know the wtf story, hehe
	
	public DoLogon() {
		login = new LoginBean();
		viewArticle = ViewArticle.getInstance();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		ServletContext sc = getServletContext();
		HttpSession session = request.getSession(); 
		String userid = request.getParameter("user_id");
		String userpassword = request.getParameter("user_pass");

		boolean success = false;
		try {
			success = login.isValidUser(userid, userpassword);
			if( success){
				if(login.getRole().equals(Role.Administrator)){
					session.setAttribute("role", Role.Administrator.toString()); 
					
					List<String> listArticle = viewArticle.getAllTitle();
					request.setAttribute("listTitle", listArticle) ; 

					RequestDispatcher rd = sc.getRequestDispatcher("/jsp/AdminPage.jsp");
					rd.forward(request, response);
				}else if(login.getRole().equals(Role.User)){
					session.setAttribute("role", Role.User.toString()); 
					RequestDispatcher rd = sc.getRequestDispatcher("/jsp/UserPage.jsp");
					rd.forward(request, response);
				}
			}else{
				RequestDispatcher rd = sc.getRequestDispatcher("/jsp/Logon.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}

}

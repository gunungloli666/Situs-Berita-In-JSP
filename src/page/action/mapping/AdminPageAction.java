package page.action.mapping;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import situs.berita.common.bean.ViewArticle;

public class AdminPageAction extends HttpServlet{
	
	private ViewArticle viewArticle; 
	
	public AdminPageAction(){
		viewArticle = ViewArticle.getInstance();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			List<String> listArticle = viewArticle.getAllTitle();
			request.setAttribute("listTitle", listArticle) ; 
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/AdminPage.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try{
			List<String> listArticle = viewArticle.getAllTitle();
			request.setAttribute("listTitle", listArticle) ; 
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/AdminPage.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			
		}
	}
	
}

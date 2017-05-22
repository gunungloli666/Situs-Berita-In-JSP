package page.action.mapping;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import situs.berita.common.bean.ModifyArticle;

public class ShowArticleAction extends HttpServlet{
	
	private ModifyArticle modify;  
	
	public ShowArticleAction(){
		modify = ModifyArticle.getInstance(); 
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request, response); 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("title");  
		try{
			String content = modify.getArticleContent(id);  
			PrintWriter writer = response.getWriter(); 
			writer.println(content); 
			writer.close(); 
		}catch(Exception e){ }
	}


}

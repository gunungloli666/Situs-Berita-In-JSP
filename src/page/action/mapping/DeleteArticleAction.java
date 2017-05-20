package page.action.mapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import situs.berita.common.bean.DeleteArticle;

public class DeleteArticleAction  extends HttpServlet{
	
	private DeleteArticle delete; 
	public DeleteArticleAction(){
		delete = DeleteArticle.getNewInstance(); 
	}
	
	public void doGet(HttpServletRequest request , HttpServletResponse response){
		String id = request.getParameter("article_id" );  
		try{
			boolean status = delete.deleteArticle(id); 
			if (status){
				request.setAttribute("status","Gagal Menghapus Artikel" ); 
			}else{
				request.setAttribute("status", "Gagal Menulis Artikel" );  
			}
			ServletContext contx = getServletContext(); 
			RequestDispatcher rd = contx.getRequestDispatcher("/jsp/Status.jsp" ); 
			rd.forward(request, response);  
		}catch(Exception e){
		}
	}

}

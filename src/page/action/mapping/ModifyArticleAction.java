package page.action.mapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import situs.berita.common.bean.DeleteArticle;
import situs.berita.common.bean.ModifyArticle;

public class ModifyArticleAction extends HttpServlet{ 
	
	private ModifyArticle modify; 
	private DeleteArticle delete; 
	
	public ModifyArticleAction(){
		modify = ModifyArticle.getInstance(); 
		delete = DeleteArticle.getNewInstance(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String task = request.getParameter("task"); 
		String id = request.getParameter("articleId"); 
		
		try{
			if("modify".equals(task)){
				String content = modify.getArticleContent(id); 
				request.setAttribute("content",  content); 
				request.setAttribute("title",  id);  
				RequestDispatcher rd = request.
						getRequestDispatcher( "/jsp/ModifyPage.jsp" ); 
				rd.forward(request , response) ;
			}else if("delete".equals(task)){
				boolean status = delete.deleteArticle(id);  
				if(status){
					request.setAttribute("status", "Berhasil Delete Article"); 
				}else{
					request.setAttribute("status", "Gagal Delete Article"); 
				}
				RequestDispatcher rd = request.
						getRequestDispatcher("adminPage" ); 
				rd.forward( request , response ) ; 
			}
		}catch(Exception e){
			System.out.println("error"); 
		}
	}

}

package page.action.mapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import situs.berita.common.bean.ModifyArticle;

public class ModifyAction extends HttpServlet{
	
	private ModifyArticle modify; 
	
	public ModifyAction(){
		modify = ModifyArticle.getNewInstance(); 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("articleId"); 
		String article = request.getParameter("article"); 
		try{
			boolean sukses = modify.modifyArticle(id, article); 
			if(sukses){
				request.setAttribute("status", "Sukses Memodifikasi Artikel");  
			}else{
				request.setAttribute("status", "Gagal Memodifikasi Artikel" ); 
			}

		RequestDispatcher rd = request.getRequestDispatcher("adminPage" ); 
		rd.forward(request, response);  
		}catch(Exception e){
			
		}
	}

}

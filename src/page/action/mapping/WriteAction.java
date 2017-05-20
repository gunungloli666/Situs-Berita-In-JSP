package page.action.mapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import situs.berita.common.bean.Write;

public class WriteAction extends HttpServlet {
	boolean success_nulis = false;

	private Write write;

	public WriteAction() {
		write = Write.getNewInstance(); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("article_id");
		String content = request.getParameter("article_content");

		try {
			if (id != null && content != null) {
				success_nulis = write.writeArticle(id, content);
				if( success_nulis) { 
					request.setAttribute("status",  "Berhasil Membuat Artikel" );  
				}else{
					request.setAttribute("status",  "Gagal Membuat Artikel" );  
				}
				RequestDispatcher rd = request.getRequestDispatcher( "adminPage" );
				rd.forward(request, response);  
			}
		} catch (Exception e) {

		}
	}

}

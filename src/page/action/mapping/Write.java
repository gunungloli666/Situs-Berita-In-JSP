package page.action.mapping;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import situs.berita.common.util.CommonName;

public class Write extends HttpServlet {
	boolean success_nulis = false;

	private situs.berita.common.bean.Write write;

	public Write() {
		write = new situs.berita.common.bean.Write();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("article_id");
		String content = request.getParameter("article_content");

		try {
			if (id != null && content != null) {
				success_nulis = write.writeArticle(id, content);
				PrintWriter out = response.getWriter();
				
//				out.println("<?xml version = \"1.0\"?>");
//				out.printf("%s%s%s", "<!DOCTYPE html PUBLIC",
//						" \"-//W3C//DTD XHTML 1.0 Strict//EN\"",
//						" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
//				out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
				
				if (success_nulis) {

					out.println("<html>"); 
					out.println("<head>");
					out.println("<title>A Simple Servlet Example</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h4>Sukses Menulis Artikel</h4>");
		
				}else{
					out.println("<html>"); 
					out.println("<head>");
					out.println("<title>A Simple Servlet Example</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h4>Gagal Menulis Artikel</h4>");
				}
				
				out.println("<table> "); 
				out.println("<tr>"); 
				String session = (String) request.getSession().getAttribute
						(CommonName.SESSION.ROLE);
				if(CommonName.SESSION.SESSION_ADMIN.equals(session)) {
					out.println("<td>"); 
					out.println("<a href=\"adminPage\" >Goto Admin Page</a>"); 
					out.println("<td>"); 
				}else if( CommonName.SESSION.SESSION_USER.equals(session)){
					out.println("<td>"); 
					out.println("<a href=\"userPage\" >Goto User Page</a>" ); 
					out.println("<td>"); 
				}
				
				out.println("</tr>"); 
				
				out.println("<tr>");
				out.println("<td>");
				out.println("<a href=\"doLogout\"><h4>Logout</h4></a>");
				out.println("</td>"); 
				out.println("</tr>"); 
				
				out.println("</table> "); 
				
				out.println("</body>");
				out.println("</html>");
				out.close();
			}
		} catch (Exception e) {

		}
	}

}

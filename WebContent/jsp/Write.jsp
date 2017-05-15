<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="write" class="situs.berita.common.bean.Write" ></jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Write</title>
</head>
<body>

<%
  boolean success_nulis = false; 

   String id = request.getParameter( "article_id" ); 
   String content = request.getParameter( "article_content" ) ;
   
   if(id != null && content != null ){
		success_nulis =    write.writeArticle(id, content); 	   
   }
%>

<%
if(success_nulis){
%>
<h4>Artikel Berhasil Dibuat</h4>
<%}else{ %>
<h4>Gagal Buat Artikel</h4>
<%} %>


<table> 
	<tr>
		<td>
			<% 
				String session_id = (String )session.getAttribute("role");
				if("Administrator".equals(session_id)) {%>
					<a href="AdminPage.jsp">Goto Admin Page</a>	
				<%}else if("User".equals(session_id )){
				%>
					<a href="UserPage.jsp">Goto User Page</a>			
				<%}%>
		</td>
	</tr>
</table>

<table>
	<tr>
		<td>
				<div>
					<b><a href="DoLogout.jsp">Logout</a></b>
				</div>
			</td>
		</tr>
	</table>
	

	
</body>
</html>
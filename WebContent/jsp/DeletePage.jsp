<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="delete" class="situs.berita.common.bean.DeleteArticle" 
scope="page" ></jsp:useBean>

<%@page import="situs.berita.common.bean.Role , situs.berita.common.util.CommonName" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Delete Page</h4>

<%
String id = request.getParameter("article_id" );  
boolean status = delete.deleteArticle(id); 
if(status){
%>
<h4>Artikel Dihapus</h4>
<%}else {%>
<h4>Artikel Gagal Dihapus </h4>
<%}%>

<table>
<tr>
<td>
	<%
	String ses = (String) session.getAttribute(CommonName.SESSION.ROLE );
	if(CommonName.SESSION.SESSION_ADMIN.equals(ses)){
		%>
		<a href="AdminPage.jsp"> Goto Admin Page</a>
		<% 
	}else if(CommonName.SESSION.SESSION_USER.equals(ses)) {
		%>
		<a href="UserPage.jsp"> Goto User Page</a>	
		<% 
	}
	%>
  </td>
  </tr>
</table>
</body>
</html>
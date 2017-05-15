<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="modify" class="situs.berita.common.bean.Modify" scope="page">
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String article = request.getParameter("article"); 
	String id = request.getParameter("article_id"); 
	if( id != null && article != null ){
		modify.modifyArticle(id , article );
%>
			<h3>Article Success Di Update</h3>
		<% 
	}else{
		%>
			<h3>Article Gagal Update</h3>
	<% }
%>

<a href="AdminPage.jsp">Back To Admin Page</a>
</body>
</html>
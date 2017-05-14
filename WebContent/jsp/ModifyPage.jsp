<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="modifyArticle" class="situs.berita.common.bean.ModifyArticle">
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>Edit Tulisan</h4> 
<%
String article_id = request.getParameter("article_id"); 
String articleviewed = modifyArticle.getArticleContent(article_id ); 
%>

<table width="100%">
<tr>
	<td><%= article_id %></td>
</tr>
<tr>
<td  width="72%" colspan="2" >
	<textarea rows="20" cols="50">
	<%= articleviewed  %>
	</textarea>
</td>
</tr>
</table>
</body>
</html>
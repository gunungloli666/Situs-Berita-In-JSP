<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean  id="modifyArticle"  class="situs.berita.common.bean.ModifyArticle"  >
</jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>Edit Tulisan</h4> 


<%
   String article_id = "";
   String articleviewed = "";
   article_id = request.getParameter("article_id"); 
   
   if(article_id != null ){
        articleviewed = modifyArticle.getArticleContent(article_id ); 
   }
%>
<form method="GET" action="Modify.jsp" > 
    <table width="100%">
        <tr>
        	<td>
        		<input type="hidden" name="article_id" value="<%= article_id %>" >
        		<%= article_id %>
        	</td>
        </tr>
        <tr>
        <td>
        	<div align="left" >
        	<textarea rows="20" cols="50"  name="article" ><%=articleviewed%></textarea>
        	</div>
        </td>
        </tr>
        <tr>
        	<td>
        	<input type="submit" value="update" ></input> 
        	</td>
        </tr>
    </table>
</form>
</body>
</html>
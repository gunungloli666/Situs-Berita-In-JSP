<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String title = (String) request.getAttribute("title"); 
String content = (String) request.getAttribute("content" ); 
%>
	<h4>Edit Tulisan</h4>
	<form method="POST" action="modify" > 
	<input type="hidden" name="articleId" value="<%= title %>" />
		<table width="100%">
			<tr>
				<td>
					<%= title  %>
				</td>
			</tr>
			<tr>
				<td>
					<div align="left">
						<textarea rows="20" cols="50" name="article"><%=content %></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="update"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>
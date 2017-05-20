<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<%

String  status = (String)request.getAttribute("status");   
%>
<h4> <%= status %></h4>

<table> 
	<tr>
		<td>
			<% 
				String session_id = (String )session.getAttribute("role");
				if("Administrator".equals(session_id)) {%>
					<a href="adminPage" >Goto Admin Page</a>	
				<%}else if("User".equals(session_id )){
				%>
					<a href="userPage" >Goto User Page</a>			
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
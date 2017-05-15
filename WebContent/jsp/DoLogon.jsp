<%@page import="situs.berita.common.bean.Role"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="login" class="situs.berita.common.bean.LoginBean" 
scope="page"></jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
     String userid = request.getParameter("user_id"); 
     String userpassword = request.getParameter("user_pass");  
     
     boolean success = false; 
     
     success = login.isValidUser(userid, userpassword); 
%>

<body>
<%
if(success){
	session.setAttribute("userid", userid ); 
	if(login.getRole().equals(Role.Administrator)){
		session.setAttribute("role", Role.Administrator.toString()); 
	%>
	<jsp:forward page="AdminPage.jsp" ></jsp:forward>
	<% 
	}else{
	    session.setAttribute("role", Role.User.toString());
	%>
	<jsp:forward page="UserPage.jsp" ></jsp:forward>
	<% }
}else{ %>

    <jsp:forward page="Logon.jsp">
    	<jsp:param name="eror" value="eror"></jsp:param>
    </jsp:forward>

<%
 }
%>
</body>
</html>
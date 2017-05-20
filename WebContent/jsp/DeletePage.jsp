<%@page import="situs.berita.common.util.CommonName"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Delete Page</h4>

<h4>
	<c:out value="${status}"></c:out>
</h4>


<%
String sesion = request.getParameter("session"); 
if( CommonName.SESSION.SESSION_ADMIN.equals(sesion)){
%>
<h4><a href="adminPage"> Back To Admin Page</a></h4>
<%}else if(CommonName.SESSION.SESSION_USER.equals(sesion)){ %>
<h4><a href="userPage"> Back To User Page</a></h4>
<%} %>
</body>
</html>
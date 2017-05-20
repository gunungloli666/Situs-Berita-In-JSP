<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Makan</title>
</head>
<body>


<h2>Contoh Penggunaan Data</h2> 
<table>
 <c:forEach items="${ listTitle}" var="nama" > 
 	<tr>
		<td>
			<c:out value="${nama }"></c:out>
		</td> 
 	</tr>
 </c:forEach>
</table>
</body>
</html>
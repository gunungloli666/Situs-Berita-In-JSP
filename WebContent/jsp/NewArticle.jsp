<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Article </title>
</head>
<body>
	
<form method="get" action="Write.jsp" >
	
	<table>
	<tr>
		<td>
		  	 <input type="text" name="article_id"  />
		</td> 
	</tr>
	<tr>
		<td>
			<textarea rows="30" cols="40" name="article_content" ></textarea>
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="submit" value="SUBMIT" />
		</td>
	</tr>
	</table>	
</form>
	
</body>
</html>
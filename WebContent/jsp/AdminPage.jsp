
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Makan</title>
</head>
<body>
	<h1>Admin Page</h1> 
	
	<h4>
		<c:out value="${status }" ></c:out>
	</h4>
	<table>
		<c:forEach items="${ listTitle}" var="nama">
			<tr>
				<td><c:out value="${nama}"></c:out></td>
				<td>
					<form method="get" action="modifyArticle">
						<input type="hidden" name="task" /> <input type="hidden"
							name="articleId" value="${nama}">
						<table>
							<tr>
								<td><input type="button" value="EDIT"
									onclick="{this.form.task.value='modify'; this.form.submit(); }" />
								</td>
								<td><input type="button" value="DELETE"
									onclick="{this.form.task.value='delete'; this.form.submit(); }" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
<table>
<tr>
	<td><a href="writeArticle" ><b>Buat Artikel Baru</b></a></td>
</tr>

<tr>
	<td><a href="logout"><b>Logout</b>
	</a></td>
</tr>
</table>
</body>
</html>
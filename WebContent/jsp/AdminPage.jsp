<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="article" class="situs.berita.common.bean.ViewArticle"
scope="session">
<%@page import="java.util.List , java.util.ArrayList , situs.berita.common.bean.Article"  %>
</jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Situs Berita Fajar</title>
</head>
<body>
<h4>Daftar Artikel</h4>
<%
List<Article> daftarArticle = article.getAllArticle(); 
%>

<table>
<%
for(Article art : daftarArticle ){
%>
 <tr>
 <td><%= art.getTitile() %></td> 
  	<td>
 	    <form method="GET" action="ModifyAndDelete.jsp" > 
 	    	<input type="hidden" name="task" />
 	    	<input type="hidden" name="article_id" value="<%= art.getTitile() %>"/>
 	    	<table>
 	    		<tr>
 					<td>
 						<input type="button" value="EDIT" onclick="{this.form.task.value='modify'; this.form.submit(); }" /> 
 					</td> 
 					<td>
 						<input type="button" value="DELETE" onclick="{this.form.task.value='delete'; this.form.submit();}" /> 
 					</td>
 	    		</tr>
 	    	</table> 
 	    </form>
 	</td>   
 
  </tr>
<%}%>
</table>
	<div align="right" >
		<table border="1" cellpadding="0" cellspacing="0" width="200"
			style="position: absolute; left: 663px; top: 121px; width: 150">
			<tr>
				<td height="18" bgcolor="#FFFFFF"><div align="center">
						<font color="#FFFFFF"><b><a href="DoLogout.jsp">Logout</a></b></font>
					</div></td>
			</tr>
		</table>
	</div>
</body>
</html>
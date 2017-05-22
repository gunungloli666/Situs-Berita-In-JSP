
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List"  %>




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Makan</title>

<%
String path = request.getContextPath(); 

%>

<link rel="stylesheet" href="<%= path%>/css/common.css" type="text/css" >


<script type="text/javascript" src="<%= path %>/script/jquery-3.2.1.min.js"> </script> 

<script type="text/javascript">
$(document).ready(
	function(){
		$('#tabelDaftar .buttonShow').click(function( ){
			var y = $(this).val(); 
			$.get('showArticle' , { title : y }, function(response){
				$('#panelShow').text(response) ;
			}); 
		}); 
		
		
		$('#tabelDaftar .buttonView').click(function (){
			var y = $(this).val();  			
 			$.ajax({
 				url : 'showArticle', 
 				data : {title : y}, 
 				type: 'get' , 
 				cache : false , 
 				success : function( response){
 					$('#panelShow').text(response) ;
 				}
 			}
 			); 
		});
	});  
</script>


</head>

	<% 
		List<String> listTitle = (List<String>) request.getAttribute("listTitle");
	%>
	
	
<body>
	<h1>Admin Page</h1>
	<h4>
		Daftar Artikel
	</h4>	
<div>
 <div  style="position : relative;  float : left; width: 700px "> 
	<table width="100%" id="tabelDaftar"  >
		<% for(String title : listTitle){ %>
			<tr class="tr-m" > 
				<td><%= title %> </td>
				<td>
					<form method="get" action="modifyArticle">
						<input type="hidden" name="task" /> 
						<input type="hidden" name="articleId" value="<%=title%>" >
						<table class="innerTable" >
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
				<td>
					<button value="<%=title%>" class="buttonView" >VIEW</button>
				</td>
								
			</tr>
		<%} %>
	</table>

	<div >
		<div id="panelShow" ></div>
	</div>
	
</div>
	
 	<div style="position: relative; float: left ; width: 100px " > 
   <table width="100%"   >
	   	<tr>
	   		<td><a href="writeArticle"><b>Buat Artikel Baru</b></a></td>
	   	</tr>
	   
	   	<tr>
	   		<td><a href="logout"><b>Logout</b> </a></td>
	   	</tr>
   </table>
   </div>
	
</div>

</body>
</html>
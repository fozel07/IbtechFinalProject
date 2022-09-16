<%@page import="com.fatih.inventory.web.client.CategoriesClient,java.io.InputStream,java.util.List,com.fatih.inventory.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
long id = Integer.parseInt(request.getParameter("categoryId"));

CategoriesClient client = new CategoriesClient();
Category category = client.Category(id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>

			<th>Category ID</th>
			<th>Category Name</th>
			
		</tr>


		
		<tr>
			<td><%=category.getCategoryId()%></td>

			<td><%=category.getCategoryName()%></td>
			

		

		</tr>
		


	</table>
</body>
</html>
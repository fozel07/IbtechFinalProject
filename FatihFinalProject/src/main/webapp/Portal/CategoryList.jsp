<%@page import="com.fatih.inventory.web.client.CategoriesClient,java.io.InputStream,java.util.List,com.fatih.inventory.Category"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CategoriesClient client=new CategoriesClient();
	
	List<Category> categoryList=client.Categories();
	
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
        
        <th>Category Name</th>
    </tr>
   
       
            <% for(Category category: categoryList){%> 
            <tr>
			
			<td><%=category.getCategoryName()%> </td>
			
			<td><form action="ProductList.jsp?categoryId=<%=category.getCategoryId()%>" method="post">
    				<input type="submit" value="Kategoriye git" />
			</form></td> 
			
			</tr>
			<%}%>
        
  
</table>




</body>
</html>
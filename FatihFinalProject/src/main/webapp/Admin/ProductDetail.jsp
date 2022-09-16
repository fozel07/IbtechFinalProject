<%@page import="com.fatih.inventory.web.client.CategoriesClient,java.io.InputStream,java.util.List,com.fatih.inventory.Category"%>
<%@page import="com.fatih.inventory.web.client.ProductClient,java.io.InputStream,java.util.List,com.fatih.inventory.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
long productId = Integer.parseInt(request.getParameter("productId"));
long categoryId = Integer.parseInt(request.getParameter("categoryId"));
CategoriesClient categoriesClient = new CategoriesClient();
ProductClient productClient=new ProductClient();
Category category = categoriesClient.Category(categoryId);
Product product =productClient.ProductsByProductId(productId);
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
        
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Sales Price</th>
        <th>Category Id</th>
        <th>Category Name</th>
       
    </tr>
   
       
            
            <tr>
			<td><%=productId%> </td>
			<td><%=product.getProductName()%> </td>
			<td><%=product.getSalesPrice()%> </td>
			<td><%=product.getCategoryId()%> </td>
			<td><%=category.getCategoryName()%> </td>
			
			
		
			
			</tr>
			
        
  
</table>

</body>
</html>
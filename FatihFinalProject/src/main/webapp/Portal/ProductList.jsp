<%@page import="com.fatih.inventory.web.client.ProductClient,java.io.InputStream,java.util.List,com.fatih.inventory.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
long id=Integer.parseInt(request.getParameter("categoryId"));

ProductClient client=new ProductClient();
List<Product> productList=client.ProductsByCategory(id);

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
        
        <th>product Name</th>
       
    </tr>
   
       
            <% for(Product product: productList){%> 
            <tr>
			<td><%=product.getProductName()%> </td>
			
			
			<td><form action="ProductView.jsp?productId=<%=product.getProductId()%>" method="post">
    				<input type="submit" value="Ürüne git" />
			</form></td> 
			
			</tr>
			<%}%>
        
  
</table>



</body>
</html>
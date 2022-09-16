<%@page import="com.fatih.shopping.web.client.CartViewClient,com.fatih.shopping.CartViewHelper,java.io.InputStream,java.util.List"%>
<%@page import="com.fatih.shopping.web.client.CartClient,com.fatih.shopping.Cart,com.fatih.shoppingManager.CartManager"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message="";
Cart cart=new Cart(1,"ismo");
List<CartViewHelper> cartProdutList = new ArrayList<>();

if(session.getAttribute("cartId")==null){
	message="sepetinizde ürün yoktur.";

}
else{
	CartViewClient viewclient=new CartViewClient();
	String cartIdString=String.valueOf(session.getAttribute("cartId"));
	long cartId=Long.parseLong(cartIdString); 
	 cartProdutList=viewclient.cartViewByCartId(cartId);
	
	
	CartManager cartManager= new CartManager();
	 cart=cartManager.find(cartId);
	
	if(request.getParameter("delete")!=null) { 
		long productId=Long.parseLong(request.getParameter("productId")) ;
		viewclient.deleteFromCart(cartId, productId);
		message="Sepetten Başarıyla silinmiştir.";
		
	}
}
	
	
%>    
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="MainPage.jsp" >Anasayfaya git</a>
<br>
<%=session.getAttribute("userName") %> Sepet Bilgileriniz Aşağıdadır.

<%if(session.getAttribute("cartId")!=null){  %> 
 <table>   <tr>
        
        <th>Product ID</th>
        <th>Product Name</th>
        <th>sales Quantity</th>
        <th>sales Price</th>
    </tr>
   
       
            <% for(CartViewHelper product: cartProdutList){%> 
            <tr>
			
			<td><%=product.getProductId()%> </td>
			
			<td><%=product.getProductName()%> </td>
			
			<td><%=product.getSalesQuantity()%> </td>
			
			<td><%=product.getSalesPrice()%> </td>
			
			
			
			</tr>
			<%}%>
      
  
</table>
Toplam fiyat <%=cart.getTotalAmount() %> TL dir.
<%}%>

<br>
<br>
<form action="CartView.jsp" method="post">
		Ürün ID'si : <input type="text" name="productId" /> <input type="submit" value="Sepetten Sil" name="delete" />
		 
	</form>
<%=message %>
</body>
</html>
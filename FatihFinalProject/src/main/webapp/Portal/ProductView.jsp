<%@page import="com.fatih.inventory.web.client.ProductClient,java.io.InputStream,java.util.List,com.fatih.inventory.Product"%>
<%@page import="com.fatih.shopping.web.client.CartClient,com.fatih.shopping.Cart,com.fatih.shoppingManager.CartManager"%>
<%@page import="com.fatih.shopping.web.client.CartProductClient,com.fatih.shopping.CartProduct,com.fatih.shoppingManager.CartProductManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
long id = Integer.parseInt(request.getParameter("productId"));
String message="";

ProductClient productclient = new ProductClient();
Product product = productclient.ProductsByProductId(id);
String userName=String.valueOf(session.getAttribute("userName"));
CartProductManager cartProductManager=new CartProductManager();

CartClient cartClient=new CartClient();
CartProductClient cartProductClient=new CartProductClient();
if(session.getAttribute("cartId")==null){
	if(request.getParameter("add")!=null){
	Cart cart=cartClient.createCart(product.getSalesPrice(),userName );
	session.setAttribute("cartId", cart.getCartId());
	CartProduct cartProduct=new CartProduct(cart.getCartId(),id,1,product.getSalesPrice());
	cartProductClient.addCart(cartProduct);
	message="Ürün sepete eklenmiştir.";
	}
}
else{
	String cartIdString=String.valueOf(session.getAttribute("cartId"));
	long cartId=Long.parseLong(cartIdString); 
	
	if(cartProductManager.findByProductIdAndCartId(id, cartId)==null){
		
	
	
		if(request.getParameter("add")!=null) { 
			CartManager cartManager=new CartManager();
			double sum =cartManager.find(cartId).getTotalAmount()+product.getSalesPrice();
		
			Cart cart=new Cart(cartId,sum,userName);
			cartClient.updateCart(cart);
		
			CartProduct cartProduct=new CartProduct(cartId,id,1,product.getSalesPrice());
			cartProductClient.addCart(cartProduct);
			message="Sepet güncellenmiştir";
		
		
		}
	}
	else {
		 
		CartManager cartManager=new CartManager();
		double sum =cartManager.find(cartId).getTotalAmount()+product.getSalesPrice();
		
		Cart cart=new Cart(cartId,sum,userName);
		cartClient.updateCart(cart);
		
		CartProduct cartProduct=cartProductManager.findByProductIdAndCartId(id,cartId);
		cartProductManager.update(cartProduct);
		message="Sepete aynı üründen bir tane daha eklenmiştir.";
		
		
		
		
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

		<a href="MainPage.jsp" >Anasayfaya git</a>   <a href="CartView.jsp" >Sepete git</a>
	
<table>
		<tr>

			<th>product Name</th>
			<th>sales Price</th>
			
		</tr>


		
		<tr>
			<td><%=product.getProductName()%></td>
			<td><%=product.getSalesPrice()%></td>
			
			
			
			<td><form action="ProductView.jsp?productId=<%=id%>" method="post">
					<input type="submit" name="add" value="Sepete Ekle" />
				</form>
			</td>

		</tr>
	</table>
<img src="<%=product.getImagePath()%>" width="300" height="300"/>	
<%=message %>

</body>
</html>
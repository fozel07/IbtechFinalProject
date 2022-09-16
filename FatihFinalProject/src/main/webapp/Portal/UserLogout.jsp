<%@page import="com.fatih.shoppingManager.CartManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("cartId")!=null){
String cartIdString=String.valueOf(session.getAttribute("cartId"));
long cartId=Long.parseLong(cartIdString); 

CartManager cartManager=new CartManager();
cartManager.deleteCart(cartId);
}


session.removeAttribute("user");
session.removeAttribute("cartId");
response.sendRedirect("UserLogin.jsp");

%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
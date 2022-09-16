<%@page import="com.fatih.authentication.web.client.UserClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String username = "";
String password = "";
String message=" ";
String checkUser="";
if(request.getParameter("login")!=null){
	   username=request.getParameter("username");
	   password=request.getParameter("password");
	   UserClient userClient=new UserClient();
	   checkUser =userClient.checkUser(username, password);
	   
	   if(checkUser.equals("true")){
		  
		   session.setAttribute("userName", username);
		   session.removeAttribute("cartId");
		   response.sendRedirect("MainPage.jsp");
	   }	   	  
	   else{
		   message="Hatalı giriş yaptınız tekrar deneyin";
		   
		   
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
<form >
		User name: <input type="text" name="username" ><br /> <br />
		Password: <input type="password" name="password" ><br /> <br />
		<input type="submit" value="Login" name="login"><br />
		<a href="UserRegister.jsp" >Register</a>
		<br />

<%=message %>
</form>

</body>
</html>
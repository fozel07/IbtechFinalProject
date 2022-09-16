<%@page import="com.fatih.authentication.web.client.UserClient,com.fatih.authentication.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String username="";
String password="";
String message="";
if(request.getParameter("register")!=null){
	
	username=request.getParameter("username");
	password=request.getParameter("password");
	
	
	UserClient userClient=new UserClient();
	boolean flag=userClient.createUser(username,password);
	
	if(flag){
		response.sendRedirect("UserLogin.jsp");
	}
	else{
		message="Bu kullanıcı adı zaten alınmış. Lütfen farklı bir kullanıcı adı giriniz";
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

<form action="UserRegister.jsp" method="post">
		User Name: <input type="text" name="username" value="<%=username %>"><br/><br/>
		Password: <input type="text" name="password" value="<%=password %>"><br/><br/>
		<input type="submit" name="register" value="Kayıt ol" ><br/><br/>
	</form>
	<a href="UserLogin.jsp">Giriş sayfasına git</a>
	<br/>
	<br/>
	<%=message %>

</body>
</html>
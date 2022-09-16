<%@page import="com.fatih.authentication.manager.UserManager,java.io.InputStream,java.util.List,com.fatih.authentication.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    
    long userId = Integer.parseInt(request.getParameter("userId"));
   UserManager userManager=new UserManager();
    User user=userManager.findByUserId(userId);
    
    
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
        
        <th>User Id</th>
        <th>User  Name</th>
        <th>User Password </th>
      
  
       
    </tr>
   
       
            
            <tr>
			<td><%=user.getUserId()%> </td>
			<td><%=user.getUserName()%> </td>
			<td><%=user.getUserPassword()%> </td>
			
			
		
			
			</tr>
			
        
  
</table>

</body>
</html>
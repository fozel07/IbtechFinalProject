<%@page import="com.fatih.authentication.manager.UserManager,java.io.InputStream,java.util.List,com.fatih.authentication.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

UserManager userManager=new UserManager();
List<User> userList=userManager.listAllUser();

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
			
			<th>Kullanıcı adı</th>
		</tr>


		<%
		for (User user : userList) {
		%>
		<tr>

			
			<td><%=user.getUserName()%></td>

			<td><form action="UserDetail.jsp?userId=<%=user.getUserId()%>" method="post">
					<input type="submit" value="Kullanıcı detaylarına git" />
				</form>
			</td>
			
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>
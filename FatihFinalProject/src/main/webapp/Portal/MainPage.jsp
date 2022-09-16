<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br> 
Merhaba <%=session.getAttribute("userName")%>	<a href="UserLogout.jsp">Çıkış Yap</a>	

<jsp:include page="CategoryList.jsp" />

</body>
</html>
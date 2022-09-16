<%@page import="com.fatih.inventory.web.client.CategoriesClient,java.io.InputStream,java.util.List,com.fatih.inventory.Category,com.fatih.inventoryManager.CategoryManager"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String messageInserted = "";
String messageDeleted = "";
CategoriesClient client = new CategoriesClient();
List<Category> categoryList = client.Categories();
CategoryManager categoryManager = new CategoryManager();
boolean isDeleted = false;
boolean isInserted = false;
if (request.getParameter("add") != null) {
	Category category = new Category(request.getParameter("category"));
	isInserted = categoryManager.insert(category);
	if (isInserted == true) {
		messageInserted = "Kategori : " + request.getParameter("category") + " eklendi";
	} else {
		messageInserted = "Zaten " + request.getParameter("category") + " kategorisi mevcut";
	}

}
if (request.getParameter("delete") != null) {
	isDeleted=categoryManager.delete(Long.parseLong(request.getParameter("categoryId")));
	if(isDeleted==true){
		messageDeleted="Kategori :"+request.getParameter("categoryId")+" başarıyla silinmiştir.";
		
	}
	else{
		messageDeleted="Lütfen geçerli bir kategori giriniz.";
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
	<table>
		<tr>
			<th>Category ID</th>
			<th>Category Name</th>
		</tr>


		<%
		for (Category category : categoryList) {
		%>
		<tr>

			<td><%=category.getCategoryId()%></td>
			<td><%=category.getCategoryName()%></td>

			<td><form action="CategoryDetail.jsp?categoryId=<%=category.getCategoryId()%>" method="post">
					<input type="submit" value="Kategoriye git" />
				</form>
			</td>
			
		</tr>
		<%
		}
		%>
	</table>




	<form action="CategorySummary.jsp" method="post">
		Category : <input type="text" name="category" /><br />
		<br /> <input type="submit" value="Category Ekle" name="add" />
		<%=messageInserted%>
	</form>
	<br /> 
	<form action="CategorySummary.jsp" method="post">
		Category Idsi giriniz : <input type="text" name="categoryId" /><br />
		<br /> <input type="submit" value="Category Sil" name="delete" />
		<%=messageDeleted%>
	</form>
</body>
</html>
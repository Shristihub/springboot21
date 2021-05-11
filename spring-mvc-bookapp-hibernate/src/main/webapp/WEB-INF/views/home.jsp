<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<div style="text-align:left;width:200px">
<a href="home">Home</a>
</div>
<div style="text-align:right">
<a href="login">Login</a>
</div>
</div>
<form action="search">
Search By Author/Category<input type="text" name="choice">
<input type="submit" value="search">
</form>
<h1>List of Books</h1>
<c:choose>
<c:when test="${empty bookList }">
${message}
</c:when>
<c:otherwise>
<table>
<tr>
<th>Title</th>
<th>Author</th>
<th>Category</th>
<th>Price</th>
<th></th>
<th></th>
</tr>
<c:forEach var="book" items="${bookList }">
<tr>
<form action = "view" method="post">
<td>${book.title }</td>
<td>${book.author }</td>
<td>${book.category }</td>
<td>${book.price}</td>
<td><input type="hidden" value = "${book.bookId}" name="bookId"></td>
<td><input type="submit" value="View"></td>
</form>
</tr>

 </c:forEach>
</table>

</c:otherwise>
</c:choose>
</body>
</html>
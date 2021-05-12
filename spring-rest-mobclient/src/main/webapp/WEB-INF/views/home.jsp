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
<div style="text-align:right">
<a href="login">Login</a>
</div>
<form action="search-by-brand">
Search By Brand<input type="text" name="brand">
<input type="submit" value="search">
</form>
<br>
<form action="search-by-brand-model">
Brand<input type="text" name="brand">
Model<input type="text" name="model">
<input type="submit" value="search">
</form>

<h1>List of Mobiles</h1>
<c:choose>
<c:when test="${empty mobileList }">
${message}
</c:when>
<c:otherwise>
<table>
<tr>
<th>Brand</th>
<th>Model</th>
<th>Price</th>
<th></th>
</tr>
<c:forEach var="mobile" items="${mobileList }">
<tr>
<form action = "view" method="post">
<td>${mobile.brand }</td>
<td>${mobile.model }</td>
<td>${mobile.price}</td>
<td><input type="hidden" value = "${mobile.mobileId}" name="mobileId"></td>
<td><input type="submit" value="View"></td>
</form>
</tr>

 </c:forEach>
</table>

</c:otherwise>
</c:choose>
</body>
</html>
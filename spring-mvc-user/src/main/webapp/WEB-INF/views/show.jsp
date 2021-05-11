<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ${username }</h1>
<form action="showItems">
Choose category<select name="category">
<option value="Mobile">Mobile
<option value="Laptop">Laptop
<option value="Headphones">Headphones

</select>
<input type="submit" value="Show">
</form>
</body>
</html>
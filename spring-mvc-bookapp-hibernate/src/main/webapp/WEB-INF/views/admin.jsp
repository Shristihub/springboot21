<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: right">
<a href="home">Home</a>
</div>
<div style="text-align: center">
<a href="addBookForm">Add Book</a><br>
<a href="editBookForm">Edit Book</a><br>
<a href="deleteBookForm">Delete Book</a><br>
</div>
<h3>
${errorMessage}
${message}
</h3>
</body>
</html>
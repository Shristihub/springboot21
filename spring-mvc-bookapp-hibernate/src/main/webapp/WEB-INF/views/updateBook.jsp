<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Update Book by Price</h1>
<form action="updateBook">
<fieldset>
<legend><b>UpdateBookForm</b></legend>
<table>
<tr><td>Title</td><td>	<input type="text" name="title" value="${book.title }" readonly></td></tr>
<tr><td>BookId</td><td><input type="text" name="bookId" value="${book.bookId }" readonly></td></tr>
<tr><td>Price</td><td><input type="text" name="price" value="${book.price }"></td></tr>
<tr><td>Author</td><td>	<input type="text" name="author" value="${book.author}" readonly></td></tr>
<tr><td>Category</td><td><input type="text" name="category" value="${book.category }" readonly></td></tr>
<tr><td colspan=2><input type="submit" value="Update Book">
</table>
</fieldset>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Get Book by Id</h1>
<form action="editBook">
<fieldset>
<legend><b>EditBookForm</b></legend>
<table>
<tr>
<td>Enter Id to update</td>
<td><input type="text" name="bookId"></td></tr>
<tr><td colspan=2><input type="submit" value="Get Book By Id"></td></tr>
</table>
</fieldset>
</form>
${message}
${errorMessage}
</body>
</html>
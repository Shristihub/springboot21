<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>List of Students</h3>
<h3>${studentList }</h3>
<h3>By City</h3>
<form action="by-city" method="get">
City<input type="text" name="city">
<input type="submit" value="Students By City">
</form>
<h3>${studentsByCity }</h3>
<h3>${errorMessage }</h3>
<h3>By Id</h3>
<form action="by-id" method="get">
Id<input type="text" name="studentId">
<input type="submit" value="Student By Id">
</form>
<h3>${student }</h3>

</body>
</html>
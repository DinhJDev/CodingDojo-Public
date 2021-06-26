<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Code</title>
</head>
<body>
	<c:out value="${errors}"/>
	<form method="POST" action="/login">
		<label>What is the code?</label>
		<input type="text" name="password">
		<button>Try Code</button>
	</form>
</body>
</html>
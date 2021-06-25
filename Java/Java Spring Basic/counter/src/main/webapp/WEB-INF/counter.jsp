<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current visit count</title>
</head>
<body>
	<h1>You have visited <a href="http://localhost:8080/">http://localhost:8080/</a> <c:out value="${count}"/> times.</h1>
	<h1><a href="http://localhost:8080/">Test another visit?</a></h1>
</body>
</html>
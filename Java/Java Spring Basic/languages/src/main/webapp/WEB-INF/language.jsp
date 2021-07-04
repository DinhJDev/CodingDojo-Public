<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<a href="/">Dashboard</a>
	<p><c:out value = "${language.name}"/></p>
	<p><c:out value = "${language.creator}"/></p>
	<p><c:out value = "${language.currentVersion}"/></p>
	<a href="/edit/${language.id}">Edit</a>
	<a href="/delete/${language.id}">Delete</a>
</body>
</html>
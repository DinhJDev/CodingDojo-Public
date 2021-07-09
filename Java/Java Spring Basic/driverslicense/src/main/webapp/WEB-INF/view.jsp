<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<h1><c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/></h1>
	<p>License Number: <c:out value="${person.license.number}"/></p>
	<p>State: <c:out value="${person.license.state}"/></p>
	<p>Expiration Date: <c:out value="${person.license.expiration_date}"/></p>
</body>
</html>
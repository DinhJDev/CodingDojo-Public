<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New Person</h1>
		<form:form action="/addPerson" method="POST" modelAttribute="person">
			<div class="form-group">
				<form:label path="first_name">First Name:</form:label>
				<form:errors path="first_name"/>
				<form:input path="first_name" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="last_name">Last Name:</form:label>
				<form:errors path="last_name"/>
				<form:input path="last_name" class="form-control"/>
			</div>
			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>
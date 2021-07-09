<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New License</h1>
		<form:form action="/addLicense" method="POST" modelAttribute="license">
			<div class="form-group">
				<form:select path="person.id">
					<c:forEach items="${allPersons}" var="person">
						<option value=${person.id}>${person.first_name} ${person.last_name}</option>
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="state" class="form-label">State:</form:label>
				<form:errors path="state"/>
				<form:input path="state" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="expiration_date" class="form-label">Expiration Date:</form:label>
				<form:errors path="expiration_date"/>
				<form:input path="expiration_date" class="form-control"/>
			</div>
			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>
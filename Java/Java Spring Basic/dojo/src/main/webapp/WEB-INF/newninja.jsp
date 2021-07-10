<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container my-md-4">
		<div class="card" style="width:500px;">
			<div class="container my-md-4">
			<h1>New Ninja</h1>
			<form:form action="/addNinja" method="POST" modelAttribute="ninja">
				<div class="form-group mb-3">
					<form:select path="dojo.id">
						<c:forEach items="${allDojos}" var="dojo">
							<option value=${dojo.id}>${dojo.name} Location</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group mb-3">
					<form:label path="firstName">First Name:</form:label>
					<form:errors path="firstName"/>
					<form:input path="firstName"/>
				</div>
				<div class="form-group mb-3">
					<form:label path="lastName">Last Name</form:label>
					<form:errors path="lastName"/>
					<form:input path="lastName"/>
				</div>
				<div class="form-group mb-3">
					<form:label path="age">Age:</form:label>
					<form:errors path="age"/>
					<form:input path="age"/>
				</div>
				<button class="btn btn-primary">Create</button>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>
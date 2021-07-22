<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="p-3">
		<h1><c:out value="${event.name}"/></h1>
		<div class="container card p-5 m-3">
			<h2>Edit Event</h2>
			<form:form action="/edit/${event.id}" method="POST" modelAttribute="event">
				<div class="mb-3">
						<form:label class="form-label" path="name">Name:</form:label>
						<form:input class="form-control" path="name"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="date">Date:</form:label>
						<form:input class="form-control" type="date" path="date"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="city">Location:</form:label>
						<div class="row">
							<div class="col">
							<form:input class="form-control" path="city"/>
							</div>
							<div class="col-md-2">
							<form:select class="form-select" path="state" items="${stateList}"/>
							</div>
						</div>
					</div>
					<button class="btn btn-primary">Edit</button>
			</form:form>
		</div>
	</div>
</body>
</html>
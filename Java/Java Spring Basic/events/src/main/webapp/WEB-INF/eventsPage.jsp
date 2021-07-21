<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="p-3">
		<div class="container">
			<div class="row">
				<div class="col">
					<h1>Welcome, <c:out value="${user.firstName}"/></h1>
				</div>
				<div class="col-md-1">
					<button href="/logout" class="btn btn-danger">Logout</button>
				</div>
			</div>
			<p>Here are some of the events in your state:</p>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Date</th>
						<th scope="col">Location</th>
						<th scope="col">Host</th>
						<th scope="col">Action/Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${stateEvents}" var="event">
						<tr>
							<td><c:out value="${event.name}"/></td>
							<td><c:out value="${event.date}"/></td>
							<td><c:out value="${event.city}"/></td>
							<td><c:out value="${event.host}"/></td>
							<td><button class="btn btn-primary">Join</button>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h2>Create an Event</h2>
			<form:form method="POST" action="/createEvent" modelAttribute="event">
				<form:errors path="user.*"/>
					<div class="mb-3">
						<form:label class="form-label" path="name">Name:</form:label>
						<form:input class="form-control" path="name"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="date">Date:</form:label>
						<form:input class="form-control" path="date"/>
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
			</form:form>
		</div>
	</div>
</body>
</html>
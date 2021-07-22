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
					<a href="/logout"><button class="btn btn-danger">Logout</button></a>
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
							<td><c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/></td>
							<td>
								<c:choose>
									<c:when test="${user.id==event.host.id}">
										<a href="/events/${event.id}/edit"><button class="btn btn-primary">Edit</button></a>
										<a href="/delete/${event.id}"><button class="btn btn-danger">Delete</button></a>
									</c:when>
									<c:otherwise>
										<button class="btn btn-primary">Join</button>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>Here are some of the events in other states:</p>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Date</th>
						<th scope="col">Location</th>
						<th scope="col">State</th>
						<th scope="col">Host</th>
						<th scope="col">Action/Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nonStateEvents}" var="event">
						<tr>
							<td><c:out value="${event.name}"/></td>
							<td><c:out value="${event.date}"/></td>
							<td><c:out value="${event.city}"/></td>
							<td><c:out value="${event.state}"/></td>
							<td><c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/></td>
							<td>
								<c:choose>
									<c:when test="${user.id==event.host.id}">
										<button class="btn btn-primary">Edit</button>
										<button class="btn btn-danger">Delete</button>
									</c:when>
									<c:otherwise>
										<button class="btn btn-primary">Join</button>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h2>Create an Event</h2>
			<form:form method="POST" action="/createEvent" modelAttribute="event">
				<form:errors path="event.*"/>
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
					<button class="btn btn-secondary">Create</button>
			</form:form>
		</div>
	</div>
</body>
</html>
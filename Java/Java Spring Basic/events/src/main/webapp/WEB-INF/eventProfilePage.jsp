<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${event.name}"/></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="p-3">
		<h1><c:out value="${event.name}"/></h1>
		<div class="container row">
			<div class = "container col p-5 m-3 card">
				<p><strong>Host:</strong> <c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/></p>
				<p><strong>Date:</strong> <c:out value="${event.date}"/></p>
				<p><strong>Location:</strong> <c:out value="${event.city}"/>, <c:out value="${event.state}"/></p>
				<p><strong>People who are attending this event:</strong> <c:out value="${event.attendees.size()}"/></p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${participants}" var="participant">
							<td><c:out value="${participant.firstName}"/> <c:out value="${participant.lastName}"/></td>
							<td><c:out value="${participant.city}"/></td>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class = "container col p-5 m-3 card">
				<h2>Message Wall</h2>
				<div style="height:250px;width:auto;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;">
					<c:forEach items="${comments}" var="comment">
						<p><strong><c:out value="${comment.commenter.firstName}"/> says: </strong> <c:out value="${comment.content}"/></p>
					</c:forEach>
				</div>
				<p><strong>Add Comment:</strong></p>
				<form:form method="POST" action="/sendComment/${event.id}" modelAttribute="comment">
					<div class="mb-3">
						<form:input class="form-control" path="content"/>
					</div>
					<button class="btn btn-primary">Submit</button>
				</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Creator</th>
					<th>Current Version</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${allLanguages}" var="language">
					<tr>
						<td>${language.id}</td>
						<td>${language.name}</td>
						<td>${language.creator}</td>
						<td>${language.currentVersion}</td>
					</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="container">
		<div class="card w-50">
			<div class="card-header">
			</div>
			<c:forEach items="${error}" var="err">
			<p>${err}</p>
			</c:forEach>
			<form action="/addRecord" method="POST">
				<div class="mb-3">
					<label for="name" class="form-label">Language Name</label> 
					<input type="text" name="name" class="form-control"> 
				</div>
				<div class="mb-3">
					<label for="creator" class="form-label">Creator</label>
					<input type="text" name="creator" class="form-control">
				</div>
				<div class="mb-3">
					<label for="currentVersion" class="form-label">Current Version</label>
					<input type="text" name="currentVersion" class="form-control">
				</div>
				<button class="btn btn-primary">Add Language</button>
			</form>
		</div>
	</div>
</body>
</html>
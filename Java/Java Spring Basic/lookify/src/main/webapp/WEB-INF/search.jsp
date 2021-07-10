<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			        	<a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
			        </li>
			    </ul>
			</div>
		</nav>
		<h1>Songs by artist: <c:out value="${artist}"/></h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${searchResults}" var="song">
					<tr>
						<td><a href="/songs/${song.id}/">${song.title}</a></td>
						<td>${song.rating}</td>
						<td><a href="/delete/${song.id}">Delete</a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			        	<a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
			        </li>
			    </ul>
			</div>
		</nav>
		<table class="table">
			<tr>
				<th><p>Title</p></th>
				<td><p><c:out value = "${song.title}"/></p></td>
			</tr>
			<tr>
				<th><p>Artist</p></th>
				<td><p><c:out value = "${song.artist}"/></p></td>
			</tr>
			<tr>
				<th><p>Rating</p></th>
				<td><p><c:out value = "${song.rating}"/></p></td>
			</tr>
			<tr>
				<td><a href="/delete/${song.id}">Delete</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
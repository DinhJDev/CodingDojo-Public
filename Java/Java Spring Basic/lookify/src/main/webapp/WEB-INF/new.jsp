<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
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
		<form:form action="/addRecord" method="POST" modelAttribute="song">
			<div class="form-group">
				<form:label path="title" class="form-label">Title:</form:label>
				<form:errors path="title"/>
				<form:input path="title" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="artist" class="form-label">Artist:</form:label>
				<form:errors path="artist"/>
				<form:input path="artist" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="rating" class="form-label">Rating:</form:label>
				<form:errors path="rating"/>
				<form:select path="rating" class="form-select">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
					<option value=6>6</option>
					<option value=7>7</option>
					<option value=8>8</option>
					<option value=9>9</option>
					<option value=10>10</option>		
				</form:select>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container my-md-4 card" style="width: 800px;">
	<h1>What is your question?</h1>
	<form:form action="/addQuestion" method="POST" modelAttribute="question">
		<div class="mb-3">
			<form:label path="content" class="form-label">Question:</form:label>
			<form:input path="content" class="form-control"/>
		</div>
		<div class="mb-3">
			<label for="tagList" class="form-label">Tags:</label>
			<input name="tagList" class="form-control"/>
		</div>
		<div class="row justify-content-end mb-3">
			<div class="col-2">
				<button class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form:form>
</div>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="card">
			<a href="/delete/${language.id}">Delete</a>
			<a href="/">Dashboard</a>
			<form:form action="/edit/{id}" method="POST" modelAttribute="language">
				<input type="hidden" name="_method" value="put">
					<div class="mb-3">
						<form:label path="name">Language Name</form:label> 
						<form:input path="name"/> 
					</div>
					<div class="mb-3">
						<form:label path="creator">Creator</form:label>
						<form:input path="creator"/>
					</div>
					<div class="mb-3">
						<form:label path="currentVersion">Current Version</form:label>
						<form:input path="currentVersion"/>
					</div>
					<form:button class="btn btn-primary" type="submit">Submit</form:button>
			</form:form>
		</div>
	</div>
</body>
</html>
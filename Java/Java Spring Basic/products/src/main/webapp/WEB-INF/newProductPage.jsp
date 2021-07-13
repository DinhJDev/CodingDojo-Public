<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container my-md-4">
	<div class="card" style="width:500px;">
		<div class="container my-md-4">
			<h1>New Category</h1>
			<form:form action="/addProduct" method="POST" modelAttribute="product">
				<div class="form-group mb-3">
					<form:label path="name">Name:</form:label>
					<form:errors path="name"/>
					<form:input path="name"/>
				</div>
				<div class="form-group mb-3">
					<form:label path="description">Description:</form:label>
					<form:errors path="description"/>
					<form:input path="description"/>
				</div>
				<div class="form-group mb-3">
					<form:label path="price">Price:</form:label>
					<form:errors path="price"/>
					<form:input path="price"/>
				</div>
				<button class="btn btn-primary">Create</button>
			</form:form>
		</div>
	</div>
</div>			
</body>
</html>
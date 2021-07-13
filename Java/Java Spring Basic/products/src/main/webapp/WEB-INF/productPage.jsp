<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container my-md-4">
	<div class="card">
		<h1><c:out value="${product.name}"/></h1>
		<div class="container row">
			<div class="col">
				<h2>Categories:</h2>
				<ul>
					<c:forEach items="${product.categories}" var ="category">
						<li>"${category.name}"</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<form:form action="/setCategory/${product.id}" method="POST" modelAttribute="product">
					<form:label path="categories" class="form-label">Add Category:</form:label>
					<form:select path="categories" class="form-select">
						<c:forEach items="${allCategories}" var="category">
							<c:choose>
								<c:when test="${product.categories.contains(category)}">
								</c:when>
								<c:otherwise>
									<option value=${category.id}>${category.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
					<button class="btn btn-primary">Add</button>
				</form:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
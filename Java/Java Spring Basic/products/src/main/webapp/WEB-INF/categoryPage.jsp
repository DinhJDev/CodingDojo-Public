<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container my-md-4">
	<div class="card">
		<h1><c:out value="${category.name}"/></h1>
		<div class="container row">
			<div class="col">
				<h2>Products:</h2>
				<ul>
					<c:forEach items="${category.products}" var ="product">
					<li>"${product.name}"</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<form:form action="/setProduct/${category.id}" method="POST" modelAttribute="category">
					<form:label path="products" class="form-label">Add Category:</form:label>
					<form:select path="products" class="form-select">
						<c:forEach items="${allProducts}" var="product">
							<c:choose>
								<c:when test="${category.products.contains(product)}">
								</c:when>
								<c:otherwise>
									<option value=${product.id}>${product.name}</option>
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
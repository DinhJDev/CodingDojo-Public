<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<div class="container my-md-4">
		<div class="card" style="width:500px;">
			<div class="row align-items-center">
				<button onclick="location.href='/dojos/new'" class="btn btn-primary">New Dojo</button>
				<button onclick="location.href='/ninjas/new'" class="btn btn-warning">New Ninja</button>
			</div>
			
			<form:form action="/viewDojo" method="POST" modelAttribute="dojo">
				<div class="form-group mb-3">
						<form:select path="id">
							<c:forEach items="${allDojos}" var="dojo">
								<option value=${dojo.id}><c:out value="${dojo.name}"/> Location</option>
							</c:forEach>
						</form:select>
						
						<button class="btn btn-primary">View Dojo</button>
					</div>
			</form:form>
		</div>
	</div>
</body>
</html>
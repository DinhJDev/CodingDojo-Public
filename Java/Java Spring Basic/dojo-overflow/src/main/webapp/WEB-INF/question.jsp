<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container my-md-4 card">
	<h1><c:out value="${question.content}"/></h1>
	<div class="container row">
	<h2>Tags:</h2>
	<ul>
	<c:forEach items="${question.tags}" var="tag">
		<li>${tag.subject}</li>
	</c:forEach>
	</ul>
	</div>
	<div class="container row">
		<div class="col">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Answers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${question.answers}" var="answer">
					<tr>
						<td>${answer.content}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div class="col">
			<form:form action="/addAnswer" method="POST" modelAttribute="answer">
				<div class="mb-3">
					<form:label path="content" class="form-label">Answer:</form:label>
					<form:input path="content" class="form-control"/>
				</div>
				<input type="hidden" name="question.id" value="${question.id}"/>
				<div class="row justify-content-end mb-3">
					<div class="col-3">
						<button class="btn btn-primary">Answer it!</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container my-md-4 card">
	<h1>Questions Dashboard</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Question</th>
				<th scope="col">Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allQuestions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}">"${question.content}"</a></td>
					<td>
						<c:forEach items="${question.tags}" var="tag">
							<p>"${tag.subject}"</p>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="row justify-content-end mb-3">
		<div class="col-2">
			<a href="/questions/new" class="btn btn-primary" role="button">New Question</a>
		</div>
	</div>
</div>

</body>
</html>
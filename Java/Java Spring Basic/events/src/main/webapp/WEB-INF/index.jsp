<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="p-3">
		<h1>Welcome</h1>
		<div class="container row">
			<div class = "container col p-5 m-3 card">
				<h2>Register</h2>
				<form:form method="POST" action="/registration" modelAttribute="user">
					<form:errors path="user.*"/>
					<div class="mb-3">
						<form:label class="form-label" path="firstName">First Name:</form:label>
						<form:input class="form-control" path="firstName"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="lastName">Last Name:</form:label>
						<form:input class="form-control" path="lastName"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="email">Email:</form:label>
						<form:input class="form-control" path="email"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="city">Location:</form:label>
						<div class="row">
							<div class="col">
							<form:input class="form-control" path="city"/>
							</div>
							<div class="col-md-2">
							<form:select class="form-select" path="state" items="${stateList}"/>
							</div>
						</div>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="password">Password:</form:label>
						<form:password class="form-control" path="password"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="passwordConfirmation">Password Confirmation:</form:label>
	            		<form:password class="form-control" path="passwordConfirmation"/>
					</div>
					<button class="btn btn-primary">Register</button>
				</form:form>
			</div>
			<div class = "container col m-3 p-5 card">
				<h2>Login</h2>
				<form method="post" action="/login">
			        <div class="mb-3">
			            <label class="form-label" type="email" for="email">Email</label>
			            <input class="form-control" type="text" id="email" name="email"/>
			        </div>
			        <div class="mb-3">
			            <label class="form-label" for="password">Password</label>
			            <input class="form-control" type="password" id="password" name="password"/>
			        </div>
			        <button type="submit" class="btn btn-primary">Login</button>
			    </form> 
			</div>
		</div>
	</div>
</body>
</html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
	<h1>Submitted Info</h1>
	<table>
		<tr>
			<td>Name:</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>Dojo Location:</td>
			<td>${location}</td>
		</tr>
		<tr>
			<td>Favorite Language:</td>
			<td>${language}</td>
		</tr>
		<tr>
			<td>Comment</td>
			<td>${comment}</td>
		</tr>
	</table>
</body>
</html>
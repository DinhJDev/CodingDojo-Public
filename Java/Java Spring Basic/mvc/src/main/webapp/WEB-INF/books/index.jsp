<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Books</h1>
	<table>
	<!-- ... -->
<c:forEach items="${books}" var="book" varStatus="loop">
<tr>    
    <td><c:out value="${book.title}"/></td>
    <td><c:out value="${book.description}"/></td>
    <td><c:out value="${book.language}"/></td>
    <td><c:out value="${book.numberOfPages}"/></td>
    <td><a href="/books/delete/${loop.index}">Delete</a></td>
</tr>
</c:forEach>
<!-- ... -->
</table>

	<a href="/books/new">New Book</a>
</body>
</html>
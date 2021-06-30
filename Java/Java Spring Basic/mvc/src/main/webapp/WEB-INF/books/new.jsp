<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Book</h1>
<form:form method="POST" action="/books/new" modelAttribute="book">
    <form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label>
    
    <form:label path="description">Description
    <form:errors path="description"/>
    <form:textarea path="description"/></form:label>
    
    <form:label path="language">language
    <form:errors path="language"/>
    <form:input path="language"/></form:label>
    
    <form:label path="numberOfPages">Pages
    <form:errors path="numberOfPages"/>     
    <form:input type="number" path="numberOfPages"/></form:label>
    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
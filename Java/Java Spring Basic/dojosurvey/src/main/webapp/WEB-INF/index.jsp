<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
	<form:form method="POST" action="/result" modelAttribute="survey">
		<form:label path="name">Your Name: </form:label>
		<form:input type="text" path="name"/> <br>
		
		<form:label path="location">Dojo location: </form:label> 
		<form:select path="location">
			<option value="Dallas">Dallas</option>
			<option value="Los Angeles">Los Angeles</option>
		</form:select> <br>
		
		<form:label path="language">Language: </form:label> 
		<form:select path="language">
			<option value="Java">Java</option>
			<option value="Python">Python</option>
		</form:select> <br>
		
		<form:label path="comment">Comment (optional): </form:label>
		<form:input type="text" path="comment"/> <br>
		
		<input type="submit" value="Button"/>
	</form:form>
</body>
</html>
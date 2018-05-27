<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Book</h1>
	<form:form method="post" modelAttribute="book">
		Title
		<form:input path="title" />
		<br />
		ISBN
		<form:input path="isbn" />
		<br />
		Wybierz wydawcę
		<form:select itemLabel="lastName" path="publisher" items="${publishers}" />
		<br/>
		Wybierz autorów
		<form:select itemLabel="lastName" path="authors" items="${authors}" multiple="true" />
		<br/>
		
		<input type="submit" value="Save">
	</form:form>
</body>
</html>
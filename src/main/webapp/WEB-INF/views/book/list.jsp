
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List books</h1>
	<a href="<c:url   value="/book/add"/>">Dodaj książekę</a>
	<table>
		<tr>
			<th>Title</th>
			<th>Publisher</th>
			<th>Akcje</th>
		</tr>
		<c:forEach items="${books}" var="boo">
			<tr>
				<td>${boo.title}</td>
				<td>${boo.publisher.firstName} ${boo.publisher.lastName}</td>
	
				<td><a href="<c:url   value="/book/edit/${boo.id}"/>">Edytuj</a>
					<a href="<c:url   value="/book/delete/${boo.id}"/>">Usuń</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
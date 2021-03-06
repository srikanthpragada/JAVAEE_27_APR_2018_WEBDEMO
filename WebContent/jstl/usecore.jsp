<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Core Tags</title>
</head>
<body>
	<ul>
		<c:forEach var="name" items="james,anders,roberts,micheal,hunter">
			<li>${name}</li>
		</c:forEach>
	</ul>
	<p />

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Value</th>
		</tr>
		<c:forEach var="hname" items="<%=request.getHeaderNames()%>">
			<tr>
				<td>${hname}</td>
				<td>${header[hname]}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
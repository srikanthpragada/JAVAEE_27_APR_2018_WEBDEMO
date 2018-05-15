<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="apr27"	uri="apr27"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using Custom Tags</title>
</head>
<body>
	<select>
		<apr27:jobs3>
			<option value="${id}">${title}</option>
		</apr27:jobs3>
	</select>
	<p />

	<ul>
		<apr27:jobs3>
			<li>${title},${minSalary}</li>
		</apr27:jobs3>
	</ul>





</body>
</html>
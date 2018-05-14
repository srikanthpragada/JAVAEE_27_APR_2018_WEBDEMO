<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>
	<h1>Update Salary</h1>
	<form action="updatesalary.jsp">
		Employee Id <br /> <input type="text" name="id" value="${param.id}" />
		<p />
		New Salary<br /> <input type="text" name="salary"
			value="${param.salary}" />
		<p />
		<input type="submit" value="Update" />
	</form>

	<%
		if (request.getParameter("id") == null)
			return;
	%>

	<jsp:useBean id="emp" class="beans.EmployeeBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="emp" />

	<%
		if (emp.update()) {
	%>
	         <h3>Update salary of ${emp.id} to ${emp.salary}</h3>
	<%
		} else
			out.println("Not Updated!");
	%>

</body>
</html>
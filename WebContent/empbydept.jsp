<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="oracle.jdbc.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees By Dept</title>
</head>
<body>
	<h1>Employees By Dept</h1>
	<form action="empbydept.jsp" method="get">
		Department <input type="number" name="deptid" 
		     value="${param.deptid}" />
        <input type="submit" value="Employees" />
	</form>

	<%
		String id = request.getParameter("deptid");
		if (id == null)
			return; // end JSP
	%>

    <h2>Employees</h2>
    <p></p>
	<table border="1" width="100%">
		<tr class="head">
			<th>Id</th>
			<th>First Name</th>
			<th>Salary</th>
			<th>Job</th>
		</tr>
		<%
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees where department_id = ?");
			crs.setString(1, id);
			crs.execute(); // Connect and retrieve data 
			while (crs.next()) {
		%>
		<tr>
			<td><%=crs.getString("employee_id")%></td>
			<td><%=crs.getString("first_name")%></td>
			<td><%=crs.getString("salary")%></td>
			<td><%=crs.getString("job_id")%></td>
		</tr>

		<%
			} // while 
			crs.close();
		%>

	</table>


</body>
</html>
<%@ page language="java" import="oracle.jdbc.rowset.OracleCachedRowSet"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1 {
	color: red;
}

.head {
	color: white;
	background-color: blue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
</head>
<body>
	<h1>List Of Jobs</h1>
	<table border="1" width="100%">
		<tr class="head">
			<th>Id</th>
			<th>Title</th>
			<th>Min Salary</th>
			<th>Max Salary</th>
		</tr>
		<%
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute(); // Connect and retrieve data 
			while (crs.next()) {
		%>
		<tr>
			<td><%=crs.getString("job_id")%></td>
			<td><%=crs.getString("job_title")%></td>
			<td><%=crs.getString("min_salary")%></td>
			<td><%=crs.getString("job_title")%></td>
		</tr>

		<%
			} // while 
			crs.close();
		%>

	</table>

</body>
</html>
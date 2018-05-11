<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
	import="oracle.jdbc.rowset.OracleCachedRowSet"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
</head>
<body>
	<%
		String city = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("city")) // cookie name city
				{
					city = c.getValue();
					break;
				}
			}
		}

		if (city == null) {
			response.sendRedirect("selectcity.html");
		}
	%>

	<h3>
		Movies in [<%=city%>]
	</h3>
	<ul>
		<%
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select movie from movies where lower(city) = ?");
			crs.setString(1, city.toLowerCase());
			crs.execute(); // Connect and retrieve data 
			while (crs.next()) {
				out.println("<li>" + crs.getString(1) + "</li>");
			} // while 
			crs.close();
		%>
	</ul>

</body>
</html>
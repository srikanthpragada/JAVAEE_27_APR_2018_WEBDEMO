<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today</title>
</head>
<body>
    <%!
      int v = 10; 
    %>
	<h1>
		<%
		    int v = 10; 
		
		    request.setAttribute("a1","Abc");
		    session.setAttribute("a1","Abc");
		    application.setAttribute("a1","Abc");
		    
			out.println(new java.util.Date().toString());
		%>
	</h1>

</body>
</html>
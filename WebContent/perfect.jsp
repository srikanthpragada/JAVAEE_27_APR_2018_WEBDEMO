<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfect Number</title>
</head>
<body>
	<h2>
		<%
			int num = Integer.parseInt(request.getParameter("number"));

			int sum = 0;
			for (int i = 1; i <= num / 2; i++) {
				if (num % i == 0)
					sum += i;
			}

			if (sum == num)
				out.println("Perfect Number!");
			else
				out.println("Not a Perfect Number!");
		%>
	</h2>
</body>
</html>
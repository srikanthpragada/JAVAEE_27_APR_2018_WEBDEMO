<%@ page language="java" 
    contentType="text/html; charset=ISO-8859-1"
    import="java.util.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Languages</title>
</head>
<body>
	<h1>Languages</h1>
	
	<%
	   TreeSet<String>  langs  = (TreeSet<String>) session.getAttribute("langs");
	   // if no langs is found then create it 
       if (langs == null) {
    	   langs = new TreeSet<String>();
    	   session.setAttribute("langs", langs);
       }
	%>

	<form action="langs.jsp">
		Language Name : <input type="text" name="lang" /> <input
			type="submit" value="Add" />
	</form>

	<%
	    String lang = request.getParameter("lang");
	    if (lang != null )
	    {
	    	langs.add(lang);
	    }
	%>
	
	<ul>
	   <%
	      for(String l : langs) {
	    	  out.println("<li>" + l + "</li>");
	      }
	   %>
	</ul>


</body>
</html>
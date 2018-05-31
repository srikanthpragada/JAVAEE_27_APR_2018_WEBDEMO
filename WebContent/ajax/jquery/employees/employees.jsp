<%@page import="javax.json.*" contentType="application/json"%>
<% 
    // Thread.sleep(5000);
	javax.sql.rowset.CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
	rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	rs.setUsername("hr");
	rs.setPassword("hr");
	rs.setCommand("select first_name ||  ' ' || last_name fullname, salary,to_char(hire_date,'dd-MON-yyyy') hire_date,department_name from employees join departments using(department_id) where job_id = ?");
	rs.setString(1, request.getParameter("jobid"));
	rs.execute();

	JsonArrayBuilder emps = Json.createArrayBuilder();
	while (rs.next()) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("fullname", rs.getString("fullname"));
		job.add("salary", rs.getString("salary"));
		job.add("hiredate", rs.getString("hire_date"));
		job.add("department", rs.getString("department_name"));
		emps.add(job.build());
	}

	rs.close();
	out.println(emps.build().toString());
%>

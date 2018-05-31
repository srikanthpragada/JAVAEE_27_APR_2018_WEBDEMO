package rest;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("jobs")
public class JobsService {

	@GET()
	public String get() {
		try {
			javax.sql.rowset.CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();

			JsonArrayBuilder jobs = Json.createArrayBuilder();
			while (rs.next()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", rs.getString("job_id"));
				job.add("title", rs.getString("job_title"));
				jobs.add(job.build());
			}

			rs.close();
			return jobs.build().toString();
		} catch (Exception ex) {
			return null;
		}
	}

	@GET()
	@Path("/{jobid}")
	public String getJobs(@PathParam("jobid") String jobid) {
		try {
			javax.sql.rowset.CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs where job_id = ?");
			rs.setString(1, jobid);
			rs.execute();
			if (rs.next()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", rs.getString("job_id"));
				job.add("title", rs.getString("job_title"));
				return job.build().toString();
			} else {
                // Send  404 status to client 
				return null;
			}

		} catch (Exception ex) {
			return null;
		}
	}
}

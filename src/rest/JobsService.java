package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ServerErrorException;

@Path("jobs")
public class JobsService {

	// /jobs
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

	// /jobs/id
	@GET()
	@Path("/{jobid}")
	public String getJob(@PathParam("jobid") String jobid) {
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
				// Send 404 status to client
				throw new NotFoundException();
			}

		} catch (SQLException ex) {
			throw new ServerErrorException(ex.getMessage(), 500);
		}
	}

	@DELETE
	@Path("/{jobid}")
	public void deleteJob(@PathParam("jobid") String jobid) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = 
					DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); 
				PreparedStatement ps = con.prepareStatement
						("delete from jobs where job_id = ?");
				ps.setString(1,jobid);
				int count = ps.executeUpdate();
				if (count == 0)
					throw new NotFoundException();
		} 
		catch (SQLException | ClassNotFoundException ex) {
			throw new ServerErrorException(ex.getMessage(),500);
		}
	} // deleteJob() 
}

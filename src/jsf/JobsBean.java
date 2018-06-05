package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class JobsBean {
	
	// property jobs 
	public RowSet getJobs() throws Exception {
		RowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs ");
		rs.execute(); // Connect and retrieve data
		return rs;
		
	}
	
	public List<Job> getAllJobs() throws Exception {
		ArrayList<Job> jobs = new ArrayList<>();
		RowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs ");
		rs.execute(); // Connect and retrieve data
		while(rs.next()) {
			jobs.add(new Job(rs.getString(1), rs.getString(2)));
		}
		rs.close();
		return jobs;
	}

}

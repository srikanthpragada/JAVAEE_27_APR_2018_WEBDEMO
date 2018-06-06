package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class JobsBean {
	private String jobid;
	private CachedRowSet employees;

	public CachedRowSet getEmployees() {
		return employees;
	}
	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

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
		while (rs.next()) {
			jobs.add(new Job(rs.getString(1), rs.getString(2)));
		}
		rs.close();
		return jobs;
	}

	// property jobs
	public ArrayList<SelectItem> getTitles() throws Exception {
		RowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs ");
		rs.execute(); // Connect and retrieve data
		ArrayList<SelectItem> items = new ArrayList<>();
		while (rs.next()) {
			items.add(new SelectItem(rs.getString(1), rs.getString(2)));
		}
		return items;
	}
	
	public void processSelection(ActionEvent evt)  {
		try {
		employees = new OracleCachedRowSet();
		employees.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		employees.setUsername("hr");
		employees.setPassword("hr");
		employees.setCommand("select * from employees where job_id = ?");
		employees.setString(1,jobid);
		employees.execute(); // Connect and retrieve data
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}

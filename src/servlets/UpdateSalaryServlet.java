package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateSalaryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int status = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con.prepareStatement("update employees set salary =  ? where employee_id = ?");
			ps.setString(1, request.getParameter("salary"));
			ps.setString(2, request.getParameter("empid"));
			int count = ps.executeUpdate();
			if (count == 0)
				status = 1; // emp not found
		} catch (Exception e) {
			e.printStackTrace();
			status = 2; // error
		}

		response.setContentType("text/plain");
		response.getWriter().println(status);

	}

}

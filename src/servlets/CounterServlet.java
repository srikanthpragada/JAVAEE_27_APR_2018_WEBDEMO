package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter") 
public class CounterServlet extends HttpServlet {
	private int counter = 0;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

//	public void destroy() {
//		System.out.println("destroy()");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.counter++;
		response.getWriter().println("<h1>" + counter + "</h1>");
	}

}

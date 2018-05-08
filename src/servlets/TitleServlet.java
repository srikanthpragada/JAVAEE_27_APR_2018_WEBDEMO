package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TitleServlet extends HttpServlet {
	private String title = "Srikanth Technologies";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
        String title = config.getInitParameter("title");
        if ( title != null)
        	this.title = title; 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<h2>" + title + "</h2>");
	}

}

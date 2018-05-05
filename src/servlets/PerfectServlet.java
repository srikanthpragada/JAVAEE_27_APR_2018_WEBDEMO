package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/perfect")
public class PerfectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("number");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		try {
			int num = Integer.parseInt(input);

			int sum = 0;
			for (int i = 1; i <= num / 2; i++) {
				if (num % i == 0)
					sum += i;
			}

			if (sum == num)
				writer.println("<h2>Perfect Number!</h2>");
			else
				writer.println("<h2>Not a Perfect Number!</h2>");

		} catch (NumberFormatException ex) {
			writer.println("<h2>Sorry! Invalid Input. Please try again!</h2>");
		}

	}

}

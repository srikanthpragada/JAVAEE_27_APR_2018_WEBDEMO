package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private int sno=1;
	
	public void init() {
		// read sno from file 
	}
	public void destroy() {
		// write sno into file 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		Part p1 = request.getPart("image");
	    InputStream is = p1.getInputStream();
	    FileOutputStream fos = new FileOutputStream("e:\\classroom\\apr27ee\\image_" + sno + ".jpg");
	    sno ++;
	    
	    while (true) {
	    	int b = is.read();
	    	if ( b == -1) // EOF
	    		break;
	    	fos.write(b);
	    }

	    fos.close();
	    
	    response.setContentType("text/html");
	    
	    response.getWriter().println(path + "<h2>Saved image successfully!</h2>");
	}

}

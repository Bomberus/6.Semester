package webapp;

import java.io.IOException;
import javax.servlet.http.*;

public class Multiplikation extends HttpServlet {
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 5120019871958287397L;

	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		response.setContentType("text/html");
		response.getWriter().println(a + "*" + b + " = " + (a*b));
	}

}

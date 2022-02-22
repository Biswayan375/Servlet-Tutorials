/*
 * In this servlet we will add two numbers and send the result sum to another servlet to make out
 * the square of that sum. We will redirect to that second servlet and we will share data among
 * servlets using sessions.
 * */

package com.servletTutorial;

import java.io.IOException;
import javax.servlet.http.*;

public class SessionDemo extends HttpServlet {
	@Override public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int num1 = Integer.parseInt(req.getParameter("num1")),
			num2 = Integer.parseInt(req.getParameter("num2")),
			sum = num1 + num2;
		
		// The data in session will be saved cross request response cycle till the value from that session
		// is not removed or the session is not destroyed. A session is a key value pair that persists in
		// between cross request response cycle.
		HttpSession session = req.getSession();
		session.setAttribute("sum", sum); // Adding the value to the session
		
		res.sendRedirect("square-sessionDemo"); // Redirecting to another servlet
	}
}

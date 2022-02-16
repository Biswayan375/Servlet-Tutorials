/*
 * In this servlet we will add two numbers and send the result sum to another servlet to make out
 * the square of that sum. We will redirect to that second servlet and we will share data among
 * servlets using URL redirect.
 * */

package com.servletTutorial;

import java.io.IOException;

import javax.servlet.http.*;

public class UrlRedirectDemo extends HttpServlet {
	@Override public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int num1 = Integer.parseInt(req.getParameter("num1")),
			num2 = Integer.parseInt(req.getParameter("num2")),
			result = num1 + num2;
		
		// Redirecting to another servlet to find the square of the sum.
		res.sendRedirect("square-urlRedirect?sum=" + result);
	}
}

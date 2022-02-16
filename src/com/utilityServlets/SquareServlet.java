/*
 * This servlet is to be called from another servlet - com.servletTutorial.CallingServletFromServlet
 * */

package com.utilityServlets;

import java.io.IOException;

import javax.servlet.http.*;

public class SquareServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// Accessing the parameter attached to the request object in the previous middleware I mean servlet.
		int result = (int) req.getAttribute("sum");
		
		// Squaring the result
		result *= result;
		
		res.setStatus(200);
		res.setContentType("application/json");
		res.getWriter().println("{\"SquareOfAddition\":" + result + "}");
	}
}

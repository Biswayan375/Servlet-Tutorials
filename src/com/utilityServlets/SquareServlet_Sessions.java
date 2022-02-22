package com.utilityServlets;

import java.io.IOException;

import javax.servlet.http.*;

public class SquareServlet_Sessions extends HttpServlet {
	@Override public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		int sum = (int) session.getAttribute("sum");
		sum *= sum;
		res.setContentType("application/json");
		res.getWriter().println("{\"sum\":" + (int) session.getAttribute("sum") + ",\"square of sum\":" + sum + "}");
//		session.removeAttribute("sum"); // We can remove attribute from session if we wish and after that it won't be available naturally
	}
}

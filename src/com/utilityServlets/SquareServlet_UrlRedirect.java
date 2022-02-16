package com.utilityServlets;

import java.io.IOException;

import javax.servlet.http.*;

public class SquareServlet_UrlRedirect extends HttpServlet {
	@Override public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int sum = Integer.parseInt(req.getParameter("sum"));
		sum *= sum;
		
		res.setStatus(200);
		res.setContentType("application/json");
		res.getWriter().println("{\"square of sum\":" + sum + "}");
	}
}

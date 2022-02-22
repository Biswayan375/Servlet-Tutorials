package com.utilityServlets;

import java.io.IOException;
import javax.servlet.http.*;

public class SquareServlet_Cookie extends HttpServlet {
	@Override public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie[] cookies = req.getCookies();
		int sum = 0;
		for (Cookie c : cookies)
			if (c.getName().equals("sum")) sum = Integer.parseInt(c.getValue());
		
		int squaredSum = sum * sum;
		res.setContentType("application/json");
		res.getWriter().println("{\"sum\":" + sum + ",\"square of sum\":" + squaredSum + "}");
	}
}

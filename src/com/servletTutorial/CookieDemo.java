package com.servletTutorial;

import javax.servlet.http.*;
import java.io.IOException;

public class CookieDemo extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int num1 = Integer.parseInt(req.getParameter("num1")),
				num2 = Integer.parseInt(req.getParameter("num2")),
				sum = num1 + num2;
		
		Cookie cookie = new Cookie("sum", String.valueOf(sum));
		res.addCookie(cookie);
		
		res.sendRedirect("square-cookieDemo");
	}
}

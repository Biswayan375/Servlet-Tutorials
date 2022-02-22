package com.IIA_Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class login extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String uname = req.getParameter("uname"), password = req.getParameter("password");
		
		req.setAttribute("username", uname);
		
		if (password.equals("admin")) {
			RequestDispatcher error_rd = req.getRequestDispatcher("IIA_ServletPages/home.jsp");
			error_rd.forward(req, res);
		}
		else {
			RequestDispatcher error_rd = req.getRequestDispatcher("IIA_ServletPages/login_error.jsp");
			error_rd.forward(req, res);
		}
	}
}
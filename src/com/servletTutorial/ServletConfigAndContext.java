package com.servletTutorial;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

/*
 * Navigate to web.xml where the initialization parameters are defined for details. 
 * */

public class ServletConfigAndContext extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String ctx_name = getServletContext().getInitParameter("name"),
				ctx_post = getServletContext().getInitParameter("post"),
				cg_name = getServletConfig().getInitParameter("name"),
				cg_post = getServletConfig().getInitParameter("post");
		
		res.setContentType("text/html");
		res.setStatus(200);
		
		PrintWriter out = res.getWriter();
		
		/*
		 * Imaging writing your whole website in the following manner. You will leave your web developer
		 * job. But wait, here comes into picture JSP to save your job. What could be more appropriate
		 * reason to appreciate JSP.
		 * */
		out.println("<html><body>");
		out.println("<h2 style=\"color: red\">Values from Servlet Context</h2><hr>");
		out.println("<h3>Hello" + ctx_name + "</h3><br><h4>Your post is " + ctx_post + "</h4>");
		out.println("<h2 style=\"color: red\">Values from Servlet Config</h2><hr>");
		out.println("<h3>Hello" + cg_name + "</h3><br><h4>Your post is " + cg_post + "</h4>");
		out.print("</body></html>");
	}
}

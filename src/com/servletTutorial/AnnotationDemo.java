package com.servletTutorial;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.annotation.*; // Must import this to be able to use annotations

/*
 * In this case, we are using Annotations, meaning we do not need to add a servlet route in our web.xml
 * which is much more tedious work than using annotations.
 * 
 * _____________________@WebServlet_____________________
 * This annotation is used to declare a class as a servlet. It is the same thing as defining
 * a servlet using <servlet></servlet> inside web.xml. The value field is to specify the specific path
 * for which this servlet is to be called. We can also specify the name of the servlet using the name
 * field. We can add initialization parameters for a servlet by specifying in initParams field. Note
 * that it takes an array of initialization parameters meaning that we must enclose the parameters inside
 * curly braces '{}' as shown in the following code.
 * 
 * _____________________@WebInitParam_____________________
 * This annotation is used to specify initialization parameters for servlet. It is also same as definig
 * these parameters inside xml but much more cleaner. We can specify the key value pair with two fields
 * namely - 'name' and 'value'.
 * */

@WebServlet(value="/AnnotationDemo", initParams={
		@WebInitParam(name="name", value="Ram"),
		@WebInitParam(name="post", value="IT")
})
public class AnnotationDemo extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		res.setStatus(200);
		
		PrintWriter out = res.getWriter();
		out.println("{\"message\": "
				+ "\"You have routed to this page with the help of annotations and not web.xml\","
				+ "\"name\":\"" + getInitParameter("name") + "\","
				+ "\"post\":\"" + getInitParameter("post") + "\"}");
	}
}
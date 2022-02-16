/*
 * The most basic basic servlet to grasp the basic working servlets. Beleive me, if you already know NodeJS, 
 * this servlet thing will be a piece of cake to you!!!
 * */

package com.servletTutorial;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	
	/*
	 * _______________________req & res_______________________
	 * Now, like in javascript, in java also, the req and res are nothing but request and response
	 * objects. Obviously, we don't need to create those objects, they will be provided to us by
	 * tomcat server. It is the difference between apache tomcat server and normal apache server or
	 * any other server say nginx. Tomcat server is purely a java servlet engine. If you want to write
	 * your backend code, you must need tomcat, it will provide you with the enviornment to write your
	 * backend in java.
	 * HttpServletRequest and HttpServletResponse are not classes but interfaces. Their implementation
	 * is done by tomcat. Tom is not that bad but he loves Jerry...
	 * 
	 * _______________________service()_______________________
	 * User's request data will be processed in our servlets. A servlet is nothing but a java class.
	 * In order to process the request data, we must have a method. That method is this service method.
	 * Obviously the name should be as it belongs to a service lifecycle.
	 * 
	 * The parameters to this method is as same as node - req and res. Basically this is a controller
	 * that is called automatically for a specific route and when called, the request is get served by
	 * this method called service. As simple as that if you are familiar with NodeJS.
	 * 
	 * For which route which servlet will get called and which java class represents which servlet or
	 * controller is configured inside that web.xml inside WebContent/WEB-INF.
	 * 
	 * _______________________doGet() & doPost()_______________________
	 * Here is a catch. service is a generic method. Meaning, whether the request method is get or post
	 * or anything else this method will get called to send the response or in other words, to service
	 * the request. But if we want to service only get requests and not post ones or vice versa then what
	 * we can do is change the method name to doGet() which services only get requests or doPost() that
	 * services only post requests.
	 * 
	 * ***********************NOTE***********************
	 * The service() method is defined inside HttpServlet class. Inside that default implementation, 
	 * it calls doGet() method if the request method is get and calls doPost() method if the request
	 * method is post. This is how things work internally.
	 * */
//	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		add(req, res);
//	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("Get request");
		add(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("Post request");
		add(req, res);
	}
	
	private static void add(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// Here also we get values by 'name' field and not 'id' or 'class'
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		int sum = num1 + num2;
		
		String jsonContentType = "application/json";
		String htmlContentType = "text/html";
		String jsonResponse = "{\"result\":" + sum + "}";
		String htmlResponse = "<h1 style='color: green'>Result is: " + sum + "</h1>";
		
		res.setContentType(htmlContentType);
		res.setStatus(200);
		res.getWriter().println(htmlResponse); // To send the response
	}
}

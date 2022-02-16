/*
 * As we can think of servlets as Express middlewares, we may need those middlewares to communicate with
 * each other i.e. sending data from one servlet to another. There are actually two ways of doing such
 * thing - one with RequestDispatcher and the other one with sendRedirect()
 * 
 * _____________________RequestDispatcher_____________________
 * Suppose we have a servlet s1 and another servlet s2. Say, s1 calculates a + b and s2 calculates the
 * square of the result of the summation done in s1. In this case, we must send the result from s1 to
 * s2. As in Express middlewares, we can also attach data to request object and send that request object
 * to the second servlet and after that in the second sevlet we can access that data from that request
 * object (done below). The final result will be sent to client by s2. But the client that is the browser
 * won't know that. The URL will be of s1's also. And this is because I am giving example of Express
 * middlewares so much.
 * 
 * _____________________sendRedirect()_____________________
 * But there could be scenarios where we actually may want our client to actually know from where the
 * response is coming in or in other words, we may want our client to actually navigate to that second
 * servlet's URL. For example, when we click Pay on some website, we are actually redirected to that
 * payment gateway. But using this method we must keep in mind that if we want to send data between
 * servlets, we cannot do that by just attaching data to the request object. Because, if you come to
 * think of it deeply, you do a request to s1 servlet with request object say req1. Then, from that
 * servlet, you are redirected to s2 servlet. Now you are actually navigating to that new URL of s2, 
 * meaning a request object say req2. Therefore, attaching some data to a request object won't work
 * in this scenario. We can use sessions or we can pass values through URL (params) like -
 * http://loclhost:8080/abc/def?x=10,y=15 (this method of passing data between servlets is called URL
 * redirecting)
 * */

package com.servletTutorial;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

public class CallingServletFromServlet extends HttpServlet {
	// In this servlet, we will add two numbers and then pass the result to other servlet.
	@Override public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		int num1 = Integer.parseInt(req.getParameter("num1")),
			num2 = Integer.parseInt(req.getParameter("num2"));
		int sum = num1 + num2;
		
		// Appending the result to the request object
		req.setAttribute("sum", sum);
		
		// We need to have another route set through our web.xml to call that servlet. Now you might appreciate
		// Node and Express better if you know...
		RequestDispatcher rd = req.getRequestDispatcher("square");
		rd.forward(req, res);
	}
}

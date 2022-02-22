<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% out.print("Hello from JSP from Scriplet Tag"); %>
	<br>
	<%= "Hello from JSP Expression Tag" %>
	<br>
	<span style='color: green'>Current Time: </span><%= java.util.Calendar.getInstance().getTime() %>
	<%!
		// This is called declaration tag. We can define variables and methods here.
		int num = 10;
	%>
</body>
</html>
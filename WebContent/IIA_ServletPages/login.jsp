<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 style="color: green">LOGIN</h1>
		<form class="login_form" action="../login" method="POST">
			<input type="text" name="uname" placeholder="Enter your username" required>
			<input type="password" name="password" placeholder="Enter your password" required>
			<button type="submit">Login</button>
		</form>
	</body>
</html>
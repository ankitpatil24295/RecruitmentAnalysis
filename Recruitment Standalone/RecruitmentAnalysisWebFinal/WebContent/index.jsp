<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>HOME PAGE</title>

<style>
body {
	color: white;
}
</style>
</head>
<h1 style="padding-left: 350px"><b>Allianz Technology</b></h1>
<body bgcolor="brown">
	<a style="padding-left: 50px" href=""><font style="color: white">ABOUT
			US</font></a>
	<a style="padding-left: 50px" href="CarrerServlet"><font
		style="color: white">CARRERS</font></a>
	<a style="padding-left: 50px" href="AboutUsServlet"><font
		style="color: white">CONTACT US</font></a>
	<br>
	<hr>
	<br>
	<h3 style="padding-left: 350px">Login Page</h3>
	<br>
	<br>
	<form style="padding-left: 350px" action="LoginServlet" method="post">
		<b>HR UserID&nbsp;<input type="text" name="hrID"><br>
			<br> <b>Password&nbsp; &nbsp;&nbsp;&nbsp;<input
				type="password" name="hrpass"><br> <br> <input
				type="submit" value="Login">
	</form>
</body>
</html>
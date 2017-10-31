<%@page import="com.recruitment.model.Position"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply For Position</title>
</head>
<style>
body {
	color: white;
}
</style>
<body bgcolor="brown">
<h1 align="center"><b>Apply For Position <%=request.getAttribute("id")%></b></h1>
<br>
<br>
<hr>
<br>
<br>
<form action="AddApplicantServlet" method="get">
		<font style="padding-left: 300px">Applicant Name:</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input align="middle" type="text" name="aname"><br>
		<br><font style="padding-left: 300px"> Applicant Skill Set:</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="askillset"><br>
		<br> <font style="padding-left: 300px">Applicant Experience:</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="aexp"><br>
		<br><font style="padding-left: 300px"> Applicant Applied Position:</font>&nbsp;&nbsp;<input type="text"
			name="applyposition" value="<%=request.getAttribute("id")%>"
			readonly="readonly">
			<br><br><font style="padding-left: 300px"><input type="submit" value="Apply">
	</form>
</body>
</html>
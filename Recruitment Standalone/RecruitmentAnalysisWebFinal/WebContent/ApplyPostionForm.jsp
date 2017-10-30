<%@page import="com.recruitment.model.Position"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="AddApplicantServlet" method="get">
		Applicant Name<input type="text" name="aname"><br>
		<br> Applicant Skill Set<input type="text" name="askillset"><br>
		<br> Applicant Experience<input type="text" name="aexp"><br>
		<br> Applicant Applied Position<input type="text"
			name="applyposition" value="<%=request.getAttribute("id")%>"
			readonly="readonly">
			<br> <input type="submit" value="Apply">
	</form>
</body>
</html>
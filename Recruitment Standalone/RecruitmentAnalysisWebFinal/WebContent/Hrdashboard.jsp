<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
        color: white;
}
</style>
</head>
<body bgcolor="GRAY">
	<h1 style="padding-left: 350px">HR Dashbord</h1>

	<%
	//Get hrId from login servlet
	String idparam=(String)request.getAttribute("hrid");
	
		
		if (session != null) {
			String name = (String) session.getAttribute("name");
			
			out.print("Hello, " + name + " Welcome to Profile");
		}
	%>
	<hr>
	
<br>
<br>
<a style="padding-left: 20px" href="AddPositionServlet?id=<%=idparam%>"><font style="color: white">ADD POSITION</font></a>

<a style="padding-left: 430px" href="DisplayPositionServlet"><font style="color: white" >DISPLAY POSITIONS</font></a>

<br><br><br><br><a style="padding-left: 20px" href="ShowApplicantServlet"><font style="color: white">SHOW APPLICANT</font></a>

<a style="padding-left: 390px" href="ShortListedApplicantServlet"><font style="color: white">SHORTLISTED</font></a>

<br><br><br><br><a style="padding-left: 20px" href="InterviewResultServlet"><font style="color: white">INTERVIEW RESULT</font></a>

<a style="padding-left: 400px" href="JoinedEmplyoeeServlet"><font style="color: white">JOINED EMPLOYEE</font></a>


</body>
</html>
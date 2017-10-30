<%@page import="com.recruitment.model.Position"%>
<%@page import="java.util.List"%>
<%@page
	import="com.recruitment.service.implementation.PositionServiceImplementation"%>
<%@page import="com.recruitment.service.PositionService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrer</title>
<style>
body {
	color: white;
}
</style>
</head>

<body bgcolor="brown">
<h1 align="center">JOB Opening</h1>
<hr>
	<TABLE border="2" align="center">
		<TR>
			<TH><b>Postion_id</b></TH>
			<TH><b>Position_name</b></TH>
			<TH><b>Experience</b></TH>


		</TR>
		<%
			List<Position> listPosition = (List<Position>) request.getAttribute("positionList");
			for (Position position : listPosition) {
		%>
		<TR>
			<TD><%=position.getPositionId()%></TD>
			<TD><%=position.getPositionName()%></TD>
			<TD><%=position.getPositionExperience()%></TD>
			<TD><a href="ApplyformServlet?id=<%=position.getPositionId()%>"><font style="color: white"><b>APPLY</b></font></a></TD>
		</TR>
		<%
			}
		%>
	</TABLE>
</body>
</html>
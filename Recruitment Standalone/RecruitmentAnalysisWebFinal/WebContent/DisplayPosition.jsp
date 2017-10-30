<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.recruitment.model.Position"%>
<%@page import="com.recruitment.service.PositionService"%>
<%@page
	import="com.recruitment.service.implementation.PositionServiceImplementation"%>
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
<body bgcolor="brown">
<h1 align="center">Positions In Company</h1>
<hr>
<br><br>
	<%
		String name = (String) request.getSession().getAttribute("name");
	%>


	<TABLE BORDER="1" align="center">
		<TR>
			<TH>Postion_id</TH>
			<TH>Hr_id</TH>
			<TH>Position_name</TH>
			<TH>no of position</TH>
			<TH>Experience</TH>
			<TH>position_post_date</TH>
			<TH>position_status</TH>
		</TR>
		<%

   List<Position>listPosition=(List<Position>)request.getSession().getAttribute("positionList");
   
	for(Position position:listPosition)
    { %>
    	<TR>
		<TD><%=position.getPositionId()%></TD>
		<TD><%= position.getHr().getHrId() %></TD>
		<TD><%= position.getPositionName() %></TD>
		<TD><%= position.getNoOfPosition() %> </TD>
		<TD><%= position.getPositionExperience() %></TD>
		<TD><%= position.getPositionPostDate() %></TD>
		<TD><%= position.isPositionStatus() %></TD>
	</TR><% 
    }
    

%>
 
		
	</TABLE>
</body>
</html>
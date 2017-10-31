<%@page import="com.recruitment.model.Apply"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Applicant Appleid</title>
</head>
<style>
body {
        color: white;
}
</style>
<body bgcolor="gray">
<h1 align="center"><b>Applicant Applied For Postions</b></h1>
<br><br>
<hr>
<br><br>

	<TABLE border="2" align="center">
		<TR>
			<TH>Applicant_id</TH>
			<TH>Applicant_name</TH>
			<TH>Position_id</TH>
			<TH>Position_name</TH>
			<TH>date_od apply</TH>


		</TR>
		<%
			List<Apply> listapply = (List<Apply>) request.getAttribute("displayAppliedApplicants");
			for (Apply apply : listapply) {
		%>
		<TR>
			<TD><%=apply.getApplicant().getApplicantId()%></TD>
			<TD><%=apply.getApplicant().getApplicantName()%></TD>
			<TD><%=apply.getPosition().getPositionId()%></TD>
			<TD><%=apply.getPosition().getPositionName()%></TD>
			<TD><%=apply.getDateOfApply()%></TD>

		</TR>
		<%
			}
		%>
	</TABLE>
</body>
</html>
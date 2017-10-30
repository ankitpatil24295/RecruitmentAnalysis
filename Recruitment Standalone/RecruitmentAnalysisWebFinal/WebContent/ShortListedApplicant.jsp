<%@page import="com.recruitment.model.Interview"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Short listed Applicant</title>
</head>
<body>
<TABLE border="2" align="center">
		<TR>
			<TH>Applicant_id</TH>
			<TH>Position_id</TH>
			<TH>Date Of Interview</TH>
			<TH>Candidate Result</TH>
			<TH>Date Of Joining</TH>
		</TR>
		<%
		 List<Interview> shortlistedApplicantList=(List<Interview>) request.getAttribute("getshortlistedApplicant");
			for (Interview interview : shortlistedApplicantList) {
		%>
		<TR>
			<TD><%=interview.getApplicant().getApplicantId()%></TD>
			<TD><%=interview.getPosition().getPositionId()%></TD>
			<TD><%=interview.getDateOfInterview()%></TD>
			<TD><%=interview.isCandidateResult()%></TD>
			<TD><%=interview.getDateOfJoining()%></TD>
		</TR>
		<%
			}
		%>
	</TABLE>
</body>
</html>
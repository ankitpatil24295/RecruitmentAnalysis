<%@page import="com.recruitment.model.Apply"%>
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

	<TABLE border="2" align="center">
		<TR>
			<TH>Applicant_id</TH>
			<TH>Applicant_name</TH>
			<TH>Position_id</TH>
			<TH>Position_name</TH>
		</TR>
		<%
			List<Apply> listapply = (List<Apply>) request.getAttribute("displayAppliedApplicants");
			System.out.println(listapply);
			for (Apply apply : listapply) {
		%>
		<TR>
			<TD><input type="text" name="appID"
				value="<%=apply.getApplicant().getApplicantId()%>" readonly></TD>

			<TD><%=apply.getApplicant().getApplicantName()%></TD>

			<TD><input type="text" name="positionID"
				value="<%=apply.getPosition().getPositionId()%>" readonly></TD>

			<TD><%=apply.getPosition().getPositionName()%></TD>
			<TD><a
				href="updateInterview.jsp?postId=<%=apply.getPosition().getPositionId()%>&appId=<%=apply.getApplicant().getApplicantId()%>">shedule and Result</a></TD>
		</TR>
		<%
			}
		%>
	</TABLE>


	</form>
</body>
</html>
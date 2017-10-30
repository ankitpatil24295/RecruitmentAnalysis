<%@page import="com.recruitment.model.Apply"%>
<%@page import="java.util.List"%>
<%@page
	import="com.recruitment.service.implementation.ApplyServiceImplementation"%>
<%@page import="com.recruitment.service.ApplyService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Interview</title>
</head>
<style>
body {
	color: white;
}
</style>
<body bgcolor="brown">
	<%
		ApplyService applyService = new ApplyServiceImplementation();
		List<Apply> displayAppliedApplicants = applyService.displayAppliedApplicants();

		int postId = Integer.parseInt(request.getParameter("postId"));
		int appId = Integer.parseInt(request.getParameter("appId"));

		for (Apply apply : displayAppliedApplicants) {
			if (apply.getApplicant().getApplicantId() == appId && apply.getPosition().getPositionId() == postId) {
	%>
	<form action="ShortlistedServlet" method="post">
		
		ApplicationID:v<input type="text" name="appID"
			value="<%=apply.getApplicant().getApplicantId()%>" readonly>

<br> <br>Applicantion Name :<input type="text" value="<%=apply.getApplicant().getApplicantName()%>" name="appName" readonly><br>
<br> <br>PositionID :<input type="text" name="positionID" value="<%=apply.getPosition().getPositionId()%>" readonly> <br>
<br> <br>PositionName :<input type="text" name="posName" value="<%=apply.getPosition().getPositionName()%>" readonly><br>
<br> <br>Date Of Interview :<input type="date" name="date"><br>
<br> <br>Candidate Result :<select name="candidateresult">
    <option >Select</option>
    <option value="Selected">Selected</option>
    <option value="Not Selected">Not Selected</option>
</select><br> <br>
<br> <br>DateOfJoining :<input type="date" name="dateofjoin"><br>
<br> <br>joined Status :<select name="joinstatus">
    <option >Select</option>
    <option value="Joined">Joined</option>
    <option value="Not Joined">Not Joined</option>
</select><br>
	
	<br> <br> <input	type="submit" value="result Stored">
	</form>
	<%
		}
		}
	%>
</body>
</html>
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
<body bgcolor="gray">
<h1 align="center"><b>Enter Interview Details</b></h1>
<br>
<hr>
<br>
<form action="ShortlistedServlet" method="post">
<table align="center">
   <tr>
   <th></th>
   <th></th>
   </tr>
	<%
		ApplyService applyService = new ApplyServiceImplementation();
		List<Apply> displayAppliedApplicants = applyService.displayAppliedApplicants();

		int postId = Integer.parseInt(request.getParameter("postId"));
		int appId = Integer.parseInt(request.getParameter("appId"));

		for (Apply apply : displayAppliedApplicants) {
			if (apply.getApplicant().getApplicantId() == appId && apply.getPosition().getPositionId() == postId) {
	%>
	
     
<tr><td>ApplicationID:</td><td><input type="text" name="appID" value="<%=apply.getApplicant().getApplicantId()%>" readonly></td></tr>

<tr><td>Applicantion Name :</td><td><input type="text" value="<%=apply.getApplicant().getApplicantName()%>" name="appName" readonly></td></tr>

<tr><td>PositionID :</td><td><input type="text" name="positionID" value="<%=apply.getPosition().getPositionId()%>" readonly></td></tr>

<tr><td>PositionName :</td><td><input type="text" name="posName" value="<%=apply.getPosition().getPositionName()%>" readonly></td></tr>

<tr><td>Date Of Interview :</td><td><input type="date" name="date"></td></tr>

<tr><td>Candidate Result :</td><td><select name="candidateresult">
    <option >Select</option>
    <option value="Selected">Selected</option>
    <option value="Not Selected">Not Selected</option>
</select> </td></tr>
<tr><td>DateOfJoining :</td><td><input type="date" name="dateofjoin"></td></tr>
<tr><td>joined Status :</td><td><select name="joinstatus">
    <option >Select</option>
    <option value="Joined">Joined</option>
    <option value="Not Joined">Not Joined</option>
</select></td></tr>
<tr><td><input	type="submit" value="result Stored"></td></tr>
	
	<%
		}
		}
	%>
	</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>
body {
        color: white;
}
</style>
</head>
<body bgcolor="brown">

<h1 align="center">Open A Positon</h1>
<hr>
<br><br>
	<%
		String name = (String) request.getSession().getAttribute("name");
		
	%>
	<form  action="PostInDBServlet">
	<table align="center">
	   <tr>
	   <th></th>
	   <th></th>
	   </tr> 
	    
	    <tr><td>PostionID:</td><td><input  type="text" name="pid"></td></tr>
		<tr><td>Hr_id :</td><td><input name="hrid" value="<%=request.getParameter("id")%>" readonly="readonly"></td></tr>
		<tr><td>Postion_name :</td><td> <input type="text" name="pname"></td></tr>
		<tr><td>No_of_Postion :</td><td> <input type="text" name="noofpos"></td></tr>
		<tr><td>Experience_required :</td><td> <input type="text" name="expreq"></td></tr>
		<tr><td>position_status:</td><td> <input type="text" name="statuspost"></td></tr>
		<tr><td><a><input type="submit" value="Post Position"></a></td></tr>

</table>
	</form>
</body>
</html>
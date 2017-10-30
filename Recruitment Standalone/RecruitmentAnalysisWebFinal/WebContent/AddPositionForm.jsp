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
	    <font style="padding-left: 300px">PostionID :</font> <input  type="text" name="pid"><br> <br>
		<font style="padding-left: 300px">Hr_id :</font><input name="hrid" value="<%=request.getParameter("id")%>" readonly="readonly"><br> <br>
		<font style="padding-left: 300px">Postion_name :</font> <input type="text" name="pname"><br> <br>
		<font style="padding-left: 300px">No_of_Postion :</font> <input type="text" name="noofpos"><br> <br>
		<font style="padding-left: 300px">Experience_required :</font> <input type="text" name="expreq"><br>
		<br>
		<font style="padding-left: 300px"> position_status: <input type="text" name="statuspost"><br>
		<br> <a style="padding-left: 300px"><input type="submit" value="Post Position"></a>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hcl.employee.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%List<Employee> list =(ArrayList<Employee>)request.getAttribute("object"); %>
<%for(Employee e:list){ %>
<form action="saveEmployee">
<table>
		<tr><td>Enter Id:</td><td><input readonly type="text" name="emp_id" placeholder="Enter Id" value="<%=e.getEmp_id() %>"/></td></tr>
		<tr><td>Enter Name:</td><td><input type="text" name="emp_name" placeholder="Enter name" value="<%=e.getEmp_name() %>"/></td></tr>
		<tr><td>Enter Address:</td><td><input type="text" name="emp_address" placeholder="Enter Address" value="<%=e.getEmp_address() %>"/></td></tr>
		<tr><td><button type="submit" class="form">Update</button></td></tr>
</table>
		</form>
<% }%>
</body>
</html>
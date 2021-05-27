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
<h3>AddEmployee</h3>
<form action="addEmployee" method="post">
<table>
		<tr><td>Enter Id:</td><td><input type="text" name="emp_id" placeholder="Enter Id"/></td></tr>
		<tr><td>Enter Name:</td><td><input type="text" name="emp_name" placeholder="Enter name"/></td></tr>
		<tr><td>Enter Address:</td><td><input type="text" name="emp_address" placeholder="Enter Address"/></td></tr>
		<tr><td><button type="submit" class="form">Register</button></td></tr>
</table>
		</form>
		
<h3>SearchEmployee</h3>
<form action="searchEmployee">
	<table>
		<tr><td>Enter Id:</td><td><input type="text" name="emp_id" placeholder="Enter Id"/></td></tr>
		<tr><td><button type="submit" class="form">search</button></td></tr>
</table>
</form>

<%if(request.getAttribute("success")!=null) {%>
<span style="color:green;"><%=request.getAttribute("success") %></span>
<%} %>

<%if(request.getAttribute("error")!=null) {%>
<span style="color:red;"><%=request.getAttribute("error") %></span>
<%} %>

<%if(request.getAttribute("list")!=null) {%>
<%List<Employee> l = (ArrayList<Employee>)request.getAttribute("list"); %> 
 <table border="2" cellspacing="0" cellpadding="10">
<tr>
<th>Id</th>
<th>Name</th>
<th>Department</th>
<th>Delete</th>
<th>Update</th>
</tr>
<%for(Employee emp : l){%>
<tr><td><%=emp.getEmp_id() %></td>
<td><%=emp.getEmp_name() %></td>
<td><%=emp.getEmp_address() %></td> 
<td><a href="deleteEmployee/<%=emp.getEmp_id() %>">Delete</a></td>
<td><a href="updateEmployee/<%=emp.getEmp_id() %>">Update</a></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>
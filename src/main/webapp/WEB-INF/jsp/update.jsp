<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>     
 <%@page import="com.hcl.employee.beans.*" %> 
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
<tr><td>Enter Id:</td><td><input type="text" name="id" placeholder="Enter Id" value="<%=e.getId() %>"/></td></tr>
<tr><td>Enter Name:</td><td><input type="text" name="name" placeholder="Enter name" value="<%=e.getName() %>"/></td></tr>
<tr><td>Enter department:</td><td><input type="text" name="department" placeholder="Enter department" value="<%=e.getDepartment() %>"/></td></tr>
<tr><td>Enter salary:</td><td><input type="text" name="salary" placeholder="Enter salary" value="<%=e.getSalary() %>"/></td></tr>
<tr><td><button type="submit" class="form">Save</button></td></tr>
</table>
</form>
<% }%>
</body>
</html>
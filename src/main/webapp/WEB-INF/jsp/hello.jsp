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
<h2>Search Employee</h2>
<form action= "searchEmployee" method="get">
 Id: 
 <input type="text" name="id" placeholder="id">
 <a href="test.jsp"><button type="submit">SearchEmployee</button></a><br><br>
 </form>
<% if(request.getAttribute("success")!=null){ %>
<%=request.getAttribute("success") %>
<%} %>
<% if(request.getAttribute("error")!=null){ %>
<%} %>
<h2>Add Employee</h2>
<form action= "addEmployee" method="get">
 Id: 
 <input type="text" name="id" placeholder="id">
 Name:
 <input type="text" name="name" placeholder="enter name">
 Department:
 <input type="text" name="department" placeholder="enter department">
 Salary
 <input type="text" name="salary" placeholder="enter salary">
 <button type="submit">AddEmployee</button>
 </form><br>
<%if(request.getAttribute("error")!=null) {%>
<%=request.getAttribute("error") %>
<%} %>
<%if(request.getAttribute("list")!=null) {%>
<%List<Employee> l = (ArrayList <Employee>) request.getAttribute("list"); %> 
<table border="3" cellspacing="0" cellpadding="10"> 
<tr> 
<th>Id</th> 
<th>Name</th> 
<th>Department</th> 
<th>Salary</th>
<th>Update</th>
<th>Delete</th>
</tr> 
<%for(Employee emp : l){%> 
<tr>
<td><%=emp.getId() %></td> 
<td><%=emp.getName() %></td>
<td><%=emp.getDepartment()%></td>
<td><%=emp.getSalary()%></td>
<td><a href="updateEmployee/<%=emp.getId()%>"><button>Update</button></a></td>
<td><a href="deleteEmployee/<%=emp.getId()%>"><button>Delete</button></a></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>
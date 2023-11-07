
<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% String name=(String)request.getAttribute("c");
		if(name!=null)
		{
	%>
	<h2>changed by <%=name %></h2>
	<%} %>
	<%
	List<Employee> list = (List) request.getAttribute("list");
	%>
	<table border="2px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<%
		for (Employee e : list) {
		%>
		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getName()%></td>
			<td><%=e.getPhone()%></td>
			<td><%=e.getAddress()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPassword()%></td>
			<td><a href="update?id=<%=e.getId()%>"><button>Update</button></a></td>
			<td><a href="delete?id=<%=e.getId()%>"><button>Delete</button></a></td>
		</tr>
		<%
		}
		%>
	</table>
	
	<br><br>
	<a href="login.jsp"><button>LogOut</button></a>

</body>
</html>

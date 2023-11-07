<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%Employee e=(Employee)request.getAttribute("Emp"); %>
	
	<form action="edit" method="post"><br><br>
		Id:<input type="hidden" name="id" value=<%=e.getId()%> readonly="true"><br><br>
		Name:<input type="text" name="name" value=<%=e.getName()%>><br><br>
		Phone:<input type="tel" name="phone" value=<%=e.getPhone()%>><br><br>
		Email:<input type="text" name="email" value=<%=e.getEmail()%>><br><br>
		Address:<input type="text" name="address" value=<%=e.getAddress()%>><br><br>
		Password:<input type="text" name="password" value=<%=e.getPassword()%>><br><br>
		<button>Submit</button>
	</form>
	
	
</body>
</html>

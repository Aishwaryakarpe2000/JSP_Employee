<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<%=message%>
	<%
	}
	%>

	<br>
	<br>
	<form action="login" method="post">
		Email:<input type="text" name="email"><br>
		<br> Password:<input type="text" name="password"><br>
		<br>
		<button>Login</button>

	</form>
</body>
</html>


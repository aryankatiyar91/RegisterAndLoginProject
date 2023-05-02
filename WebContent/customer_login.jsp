<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<form action="logCustomer" method="post">
		<h1>Customer Login Page</h1>
		
		<label for="tbEmailLog"> Email:</label>
		<input type="email" name="tbEmailLog" id="tbEmailLog" value="<%=request.getParameter("tbEmail")%>" />
		
		<br>
		
		<label for="tbPassLog"> Password:</label>
		<input type="password" name="tbPassLog" id="tbPassLog" value="<%= request.getParameter("tbPass") %>" />
		
		<br>
		
		<input type="submit" value="Login" />
	</form>
</body>
</html>
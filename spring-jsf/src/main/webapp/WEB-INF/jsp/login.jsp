<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio del Sistema</title>
</head>
<body>
	<div>
		<form:form action="postLogin.htm" method="post" >
			<table>
				<tr>
					<td>User</td>
					<td><input type="text" name="txtUserName" value="admin"> </td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="txtPassword" value="admin"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Login">
					</td>
					
				</tr>
			</table>
		
		</form:form>
	</div>
</body>
</html>
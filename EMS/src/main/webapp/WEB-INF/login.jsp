<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User login</title>
</head>
<body>
	<div align="center">
		<h1>Employee Management System</h1>
		<br/>
		<br/>
		<h3>User login</h3>
			<form:form action="verifyLogin" modelAttribute="user">
			User Id: <form:input type="number" path="userId"/>
			<form:errors path = "userId" cssStyle="color:red"/>
			<br/>
			<br/>
			Password: <form:input type="password" path="password"/>
			<form:errors path = "password" cssStyle="color:red"/>
			<br/>
			<br/>
			<input type="submit"/>
			</form:form>
		<span style="color:red">${message}</span>
		<h4><a href="registerAdmin">Register Admin</a><br/><br/></h4>
	</div>
</body>
</html>
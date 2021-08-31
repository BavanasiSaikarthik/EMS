<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>Register New Admin</h2>
		<form:form action="registernewAdmin" modelAttribute="adminRegister">
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
		<br/>
		<br/>
		<span style="color:green">${registerMessage}</span>
		<br/>
		<br/>
	</div>
</body>
</html>
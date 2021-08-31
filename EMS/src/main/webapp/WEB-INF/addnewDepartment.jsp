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
		<h2>Add New Department</h2>
		<form:form action="addnewDepartment" modelAttribute="newDepartment">
	    Department Name: <form:input type="text" path="deptName"/>
		<form:errors path = "deptName" cssStyle="color:red"/>
		<br/>
		<br/>
		<input type="submit"/>
		</form:form>
		<br/>
		<br/>
	</div>
</body>
</html>
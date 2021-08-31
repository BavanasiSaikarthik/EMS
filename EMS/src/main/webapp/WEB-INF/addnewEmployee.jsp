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
		<h2>Add New Employee</h2>
		<form:form action="addnewEmployee" modelAttribute="newEmployee">
		Employee Id: <form:input type="number" path="empId"/>
		<form:errors path = "empId" cssStyle="color:red"/>
		<br/>
		<br/>
		First Name: <form:input type="text" path="firstname"/>
		<form:errors path = "firstname" cssStyle="color:red"/>
		<br/>
		<br/>
		Last Name: <form:input type="text" path="lastname"/>
		<form:errors path = "lastname" cssStyle="color:red"/>
		<br/>
		<br/>
		Date of Birth: <form:input type="text" path="dob"/>
		<form:errors path = "dob" cssStyle="color:red"/>
		<br/>
		<br/>
		Email: <form:input type="text" path="email"/>
		<form:errors path = "email" cssStyle="color:red"/>
		<br/>
		<br/>
		Department Id: <form:input type="number" path="deptId"/>
		<form:errors path = "deptId" cssStyle="color:red"/>
		<br/>
		<br/>
		<input type="submit"/>
		</form:form>
		<br/>
		<br/>
		<span style="color:green">${employeeMessage}</span>
		<br/>
		<br/>
	</div>
</body>
</html>
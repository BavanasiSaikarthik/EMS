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
		<h2>Add New Regulation</h2>
		<form:form action="addnewRegulation" modelAttribute="newRegulation">
		Regulation Type: <form:input type="text" path="RLtype"/>
		<form:errors path = "RLtype" cssStyle="color:red"/>
		<br/>
		<br/>
		Details: <form:input type="text" path="details"/>
		<form:errors path = "details" cssStyle="color:red"/>
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
	</div>
</body>
</html>
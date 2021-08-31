<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h2>Employees</h2>
		<c:forEach items="${employees}" var="employee">
		<div style="background-color:grey; width:250px; height:170px;">
		<h5>Name: ${employee.firstname} ${employee.lastname}</h5>
		<h5>EmpID: ${employee.empId}</h5>
		<h5>DeptID: ${employee.deptId}</h5>
		<h5>DOB: ${employee.dob}</h5>
		<h5>Email: ${employee.email}</h5>
		</div>
		</c:forEach>
<button><a href="/EMS/">Logout</a></button>	
</div>
</body>
</html>
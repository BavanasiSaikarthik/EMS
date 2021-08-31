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
		<h2>Departments</h2>
		<c:forEach items="${departments}" var="department">
		<div style="background-color:grey; width:150px; height:55px;">
		<h5>Name: ${department.deptName}</h5>
		<h5>DeptID: ${department.deptId}</h5>
		</div>
		</c:forEach>
</br>
<button><a href="/EMS/">Logout</a></button>
</div>
</body>
</html>
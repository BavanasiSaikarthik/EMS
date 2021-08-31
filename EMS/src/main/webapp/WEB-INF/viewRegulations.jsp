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
		<h2>Regulations</h2>
		<c:forEach items="${regulations}" var="regulations">
		<div style="border:3px solid grey; width:300px">
		<div style="background-color:grey; width:250px; height:170px;">
		<h5>Regulation Type: ${regulations.regulation.RLtype}</h5>
		<h5>Regulation Details: ${regulations.regulation.details}</h5>
		<h5>Date: ${regulations.regulation.date}</h5>
		<h5>DeptID: ${regulations.regulation.deptId}</h5>
		</div>
		<c:forEach items="${regulations.comment}" var="comments">
		<div style="background-color:grey; width:225px;">
		<h6>${comments.name}   ${comments.date}</h6>
		<h5>${comments.comment}</h5>
		</div>
		</c:forEach>
		</div>
		</c:forEach>
</br>
<button><a href="/EMS/">Logout</a></button>	
</div>
</body>
</html>
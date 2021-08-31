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
		<h2>Regulations Not Responded</h2>
		<c:forEach items="${notresponded}" var="regulation">
		<div style="border:3px solid grey; width:300px;">
		<div style="background-color:grey; width:250px; height:190px;">
		<h5>Regulation Type: ${regulation.RLtype}</h5>
		<h5>Regulation Details: ${regulation.details}</h5>
		<h5>Date: ${regulation.date}</h5>
		<h5>DeptID: ${regulation.deptId}</h5>
		<button><a href="comment/${regulation.complianceId}/${currentuser}">Comment</a></button>
		</div>
		</div>
		</c:forEach>
		</br>
		<h2>Regulations Responded</h2>
		<c:forEach items="${responded.values()}" var="regulation">
		<div style="border-color: 2px soild grey; width:400;">
		<div style="background-color:grey; width:300px; height:190px;">
		<h5>Regulation Type: ${regulation.regulationName.RLtype}</h5>
		<h5>Regulation Details: ${regulation.regulationName.details}</h5>
		<h5>Date: ${regulation.regulationName.date}</h5>
		<h5>DeptID: ${regulation.regulationName.deptId}</h5>
		<button><a href="submit/${regulation.regulationName.complianceId}/${currentuser}">Comment</a></button>
		</div>
		<h5>Comments</h5>
		<c:forEach items="${regulation.getStatusreports()}" var="regulatio">
		<div style="background-color:grey; width:250px">
		<h6>${regulatio.comment}</h6>
		</div>
		</c:forEach>
		</div>
		</c:forEach>
		
</br>
<button><a href="/EMS/">Logout</a></button>	
</div>
</body>
</html>
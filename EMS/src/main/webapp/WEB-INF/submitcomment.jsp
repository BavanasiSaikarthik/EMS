<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
</br>
</br>
<div style="background-color:grey; width:250px; height:170px;">
		<h5>Regulation Type: ${regulation.RLtype}</h5>
		<h5>Regulation Details: ${regulation.details}</h5>
		<h5>Date: ${regulation.date}</h5>
		<h5>DeptID: ${regulation.deptId}</h5>
		</div>
		<br/>
		<form:form action="/EMS/comment/${regulation.complianceId}/${regulation.deptId}/${userId}" modelAttribute="newcomment">
		Add Comment: <form:input type="text" path="comment"/>
		<form:errors path = "comment" cssStyle="color:red"/> 
		</br>
		</br>
		<button>Comment</button>
		</form:form>
		<br/>
	</div>
</body>
</html>
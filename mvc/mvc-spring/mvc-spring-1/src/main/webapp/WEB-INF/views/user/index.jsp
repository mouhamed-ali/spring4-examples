<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link type="text/css" href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" />
</head>
<body>
<br/>
<h1>User Manager</h1>
<br/><hr/><br/>
<ul>
	<li><a class="btn-bootstrap" href="<c:url value='/hello-mvc/user/add'/>">Add User</a></li>
	<li><a class="btn-bootstrap" href="<c:url value='/hello-mvc/user/'/>">Show Users</a></li>
</ul>
<br/><hr/><br/>
<c:if test="${not empty message}">
   <h3>${message}</h3>   
</c:if>
<br/>
<hr/>
<img src="<c:url value='/resources/images/mvc.png' />" alt="...">
</body>
</html>
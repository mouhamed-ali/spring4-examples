<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link type="text/css" href="<c:url value='/static/css/style.css'/>" rel="stylesheet" />
</head>
<body>
<br/>
<h1>Hello ${pageContext.request.userPrincipal.name} ...</h1>
<br/><hr/><br/>
<ul>
	<li><a class="btn-bootstrap" href="<c:url value='/user/add'/>">Add User</a></li>
	<li><a class="btn-bootstrap" href="<c:url value='/user/'/>">Show Users</a></li>
</ul>
<br/><hr/><br/>
<c:if test="${not empty message}">
   <h3>${message}</h3>   
</c:if>
<br/>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>
<hr/>
<img src="<c:url value='/static/images/Capture.png' />" alt="Not Found">
</body>
</html>
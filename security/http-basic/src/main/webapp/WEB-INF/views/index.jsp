<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<h1>Hello <security:authentication property="principal.username"/> !!!</h1>
<h2>You have the right to : </h2>
<hr/>

<security:authorize access="hasRole('ROLE_ADMIN')">
	<ul>
		<li>consult user's informations</li>
		<li>update users</li>
		<li>delete users</li>
	</ul>
</security:authorize>

<security:authorize access="hasRole('ROLE_USER')">
	<ul>
		<li>consult your only informations</li>
		<li>update your only informations</li>
	</ul>
</security:authorize>

<hr/>
<c:url value='/logout' var='logout'/>
<a href="${logout}">Logout</a>
</html>
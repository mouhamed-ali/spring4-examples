<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>
	<br />
	<ul>
		<li><a
			style="padding: 0 4px; background-color: #333; color: #fff; font-weight: 400;"
			href="<c:url value='/user/index'/>">Home</a></li>
	</ul>
	<hr />
	<br />
	<h1>Update Users</h1>
	<br />
	<hr />
	<spring:url value="/user/${user.id}" var="userActionUrl" />
	<form:form action="${userActionUrl}" modelAttribute="user" method="put">
		<table border="1">
			<tbody>
				<tr>
					<th>User ID</th>
					<td><form:input placeholder="${user.id}" type="number" path="id"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<th>User Name</th>
					<td><form:input placeholder="${user.name}" type="text" path="name" /></td>
				</tr>
				<tr>
					<th>User Email</th>
					<td><form:input placeholder="${user.email}" type="text"	path="email" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>
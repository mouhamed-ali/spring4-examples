<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
	<br />
	<ul>
		<li><a
			style="padding: 0 4px; background-color: #333; color: #fff; font-weight: 400;"
			href="<c:url value='/'/>">Home</a></li>
	</ul>
	<hr />
	<br />
	<h1>Update Customers</h1>
	<br />
	<hr />
	<spring:url value="/customer/${customer.id}" var="customerActionUrl" />
	<form:form action="${customerActionUrl}" modelAttribute="customer" method="put">
		<table border="1">
			<tbody>
				<tr>
					<th>Customer ID</th>
					<td><form:input placeholder="${customer.id}" type="number" path="id"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<th>Customer Name</th>
					<td><form:input placeholder="${customer.name}" type="text" path="name" /></td>
				</tr>
				<tr>
					<th>Country</th>
					<td><form:input placeholder="${customer.country}" type="text"	path="country" /></td>
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
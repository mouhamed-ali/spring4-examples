<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Customers</title>
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
	<h1>Show Customers</h1>
	<br />
	<hr />
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Country</th>
			<th>View</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="customer" items="${customers}">
			<tr>
				<td><c:out value="${customer.id}"></c:out></td>
				<td><c:out value="${customer.name}"></c:out></td>
				<td><c:out value="${customer.country}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/customer/${customer.id}">!</a></td>
				<td>
					<form:form action="${pageContext.request.contextPath}/customer/${customer.id}" method="delete">
						<button type="submit" id="submitButton">X</button>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
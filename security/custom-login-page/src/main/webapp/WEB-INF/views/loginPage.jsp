<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/static/css/style.css' />"  rel="stylesheet"></link>
<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
</head>
<body>

	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<p>Invalid username and password.</p>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<p>You have been logged out successfully.</p>
		</div>
	</c:if>

	<c:url value='/login' var='loginUrl' />
	<form name='login' action="${loginUrl}" method='POST'>
		<div class="imgcontainer">
			<img src="<c:url value='/static/images/img_avatar2.png'/>" alt="Avatar" class="avatar">
		</div>
		<div class="container">
			<label><b>Username</b></label> 
			<input type="text"
				placeholder="Enter Username" name="username" required> <label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="password"	required>
			<button name="submit" type="submit">Login</button>
			<input type="checkbox" checked="checked"> Remember me
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<!-- 
		the name = 'username' and name = 'password' are very important because they will be used by spring to create
        the security context. but we can modify them see config of the context of security
	 -->
</body>
</html>
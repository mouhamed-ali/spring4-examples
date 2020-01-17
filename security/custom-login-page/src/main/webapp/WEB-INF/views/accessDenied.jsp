<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AccessDenied page</title>
</head>
<body>
	<div class="imgcontainer">
		<img src="<c:url value='/static/images/Capture.PNG'/>"
			alt="Avatar" class="avatar">
	</div>
	<h1>
	Dear
	<strong>${pageContext.request.userPrincipal.name}</strong>, You are not
	authorized to access this page
	</h1>
	<c:url value="/logout" var="logoutUrl" />
    <form id="logout" action="${logoutUrl}" method="post" >
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
    </c:if>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <a href="${contextPath}/homePage">Home</a>
</body>
</html>
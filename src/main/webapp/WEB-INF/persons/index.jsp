<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/create/new" method="post" modelAttribute="person">
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
	
	<c:forEach items="${newPersons}" var="p">
	<tr>
		<td><c:out value="${p.firstName}"/></td>
		<td><c:out value="${p.lastName}"/> |</td>
	</tr>
	</c:forEach>
</body>
</html>
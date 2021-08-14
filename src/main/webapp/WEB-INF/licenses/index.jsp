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
	<h1>New License</h1>
	<form:form action="/create/license" method="post" modelAttribute="license">
		<p>
			<form:label path="person">Person:</form:label>
			<form:errors path="person"/>
			<form:select path="person">
				
				<c:forEach items="${licPersons}" var= "lperson">
					<form:option value="${lperson.id}"><c:out value="${lperson.firstName}"/></form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="state">state:</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</p>
		<p>
			<form:label path="expirationDate">Expiration Date:</form:label>
			<form:errors path="expirationDate"/>
			<form:input path="expirationDate" type="date"/>
		</p>
		<input type="submit" value="Create"/>
	</form:form>
	
</body>
</html>
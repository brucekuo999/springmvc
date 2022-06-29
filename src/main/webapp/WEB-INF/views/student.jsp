<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Student Registration Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>

	<h1>Enter personal information to register</h1>

	<c:url var="addAction" value="/student/add"></c:url>

	<form:form action="${addAction}" commandName="student">
		<table>

			<c:if test="${!empty student.id}">
				<tr>
					<td><form:label path="id">
							<spring:message text="Studet ID:" />
						</form:label></td>
					<td><form:input path="id" readonly="true" />
				</tr>
			</c:if>

			<tr>
				<td><form:label path="firstName">
						<spring:message text="First Name:" />
					</form:label></td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message text="Last Name:" />
					</form:label></td>
				<td><form:input path="lastName" /> <form:errors
						path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="emailAddress">
						<spring:message text="Email Address:" />
					</form:label></td>
				<td><form:input path="emailAddress" /> <form:errors
						path="emailAddress" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">
						<spring:message text="Phone:" />
					</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty student.firstName}">
						<input type="submit" value="<spring:message text="Update"/>" />
					</c:if> <c:if test="${empty student.firstName}">
						<input type="submit" value="<spring:message text="Register"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
</body>
</html>

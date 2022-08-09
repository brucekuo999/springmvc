<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Course Sign Up</title>
<LINK rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<link href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet" >
</head>
<body>

	<h1>${message}</h1>
	<h1>Enter student ID to sign up courses</h1>

	<c:url var="addAction" value="/student"></c:url>

	<div class="formcontainer">
	<form:form action="${addAction}" commandName="student">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="Student ID:" />
					</form:label></td>
				<td><form:input path="id" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Browser the courses"/>" /></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>

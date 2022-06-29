<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Course Page</title>
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
<h1><c:out value="${student.firstName}" />  <c:out value="${student.lastName}" />, courses you have signed up</h1>
	
	<c:if test="${!empty listMyCourses}">
		<table class="tg">
			<tr>
				<th width="80">Course ID</th>
				<th width="120">Course Name</th>
				<th width="120">Description</th>
				<th width="20">Credit</th>
				<th width="60">Student ID</th>
				<th width="60">Cancel</th>
			</tr>
			<c:forEach items="${listMyCourses}" var="mycourse">
				<tr>
					<td>${mycourse.id}</td>
					<td>${mycourse.name}</td>
					<td>${mycourse.description}</td>
					<td>${mycourse.credit}</td>
					<td>${student.id}</td>
					<td><a href="<c:url value='/courses/student/delete/${student.id}/?courseId=${mycourse.id}' />"><button>Cancel</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	
	<H1>Available Courses</H1>
	
		<c:if test="${!empty listCourses}">
		<table class="tg">
			<tr>
				<th width="80">Course ID</th>
				<th width="120">Course Name</th>
				<th width="120">Description</th>
				<th width="20">Credit</th>
				<th width="60">Student ID</th>
				<th width="60">Select</th>
			</tr>
			<c:forEach items="${listCourses}" var="course">
				<tr>
					<td>${course.id}</td>
					<td>${course.name}</td>
					<td>${course.description}</td>
					<td>${course.credit}</td>
					<td>${student.id}</td>
					<td><a href="<c:url value='/courses/student/add/${student.id}/?courseId=${course.id}' />"><button>Select</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

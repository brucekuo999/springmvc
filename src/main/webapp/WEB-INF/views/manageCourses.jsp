<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet" ></link>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
<title>Courses management</title>
</head>
<body ng-app="app" class="ng-cloak">


	<I><span class="lead">
		<p align="left">Welcome <strong>${student.firstName} ${student.lastName }</strong>, <BR/>
			Here is your student ID <strong>${student.id}</strong>. You may customize your courses
			for the summer term now or come back later using your ID.</p>
	</span></I>
	<div class="generic-container" ng-controller="appCtrl as ctrl">
		<div class="panel panel-default">
			<h1>
				<div class="panel-heading">
					<span class="lead">{{!ctrl.course.id ? 'Request a new course' : 'Update the course'}}</span>
				</div>
			</h1>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
					<input type="hidden" ng-model="ctrl.course.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="name">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.course.name" id="name"
									class="field form-control input-sm"
									placeholder="Enter course name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.name.$error.required">This is a
										required field</span> <span ng-show="myForm.name.$error.minlength">Minimum
										length required is 3</span> <span ng-show="myForm.name.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="description">Description</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.course.description"
									id="description" min="1" class="field form-control input-sm"
									placeholder="Enter course description" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="credit">Credit</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.course.credit" id="credit"
									min="1" class="field form-control input-sm" required
									placeholder="Enter course credit" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.credit.$error.required">This is a
										required field</span> <span ng-show="myForm.credit.$error.number">Not
										a valid number</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" ng-click="ctrl.submit()"
								value="{{!ctrl.course.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Clear
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<H1>
					<span class="lead">List of courses </span>
				</H1>
			</div>
			<div class="tablecontainer">
				<!--  <table class="table table-hover"> -->
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Credit</th>
						</tr>
					</thead>
					<tbody>

						<tr ng-repeat="allcourse in ctrl.allcourses">
							<div class="row">
							<td><span ng-bind="allcourse.id"></span></td>
							<td><span ng-bind="allcourse.name"></span></td>
							<td><span ng-bind="allcourse.description"></span></td>
							<td><span ng-bind="allcourse.credit"></span></td>
							<td><button type="button" ng-click="ctrl.remove(allcourse)"
									class="btn btn-danger custom-width">Delete</button>
								<button type="button" ng-click="ctrl.modify(allcourse)"
									class="btn btn-success custom-width">Update</button></td>
							</div>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="<c:url value='/resources/js/course.js' />"></script>
</body>
</html>
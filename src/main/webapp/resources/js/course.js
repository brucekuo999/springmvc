"use strict";

var app = angular.module("app", []);

var RESTFUL_URI = "http://localhost:8083/Springmvc-registration/course/";

app.controller("appCtrl", function($scope, $http, $log) {
	
	$scope.course = { id: null, name: "", description: "", credit: null };	
	$scope.allcourses = [];

	$scope.getAllCourses = getAllCourses;
	$scope.submit = submit;
	$scope.modify = modify
	$scope.remove = remove;
	$scope.reset = reset;
	

	//Now load all courses from server
	getAllCourses();

	function createCourse() {
		$log.log("From the createCourse is called");
		$log.log($scope.course);
		
		$http({ method: "POST", url: RESTFUL_URI, data: $scope.course })
			.then(function successCallback(response) {
				$scope.allcourses = response.data.courses;
				$log.log(response.data.courses);
			}
				, function errorCallback(response) {
					$log.log(response.statusText);
				})
	};

	function getAllCourses() {
		$log.log("From the getAllCourses");
		$http({ method: "GET", url: RESTFUL_URI })
			.then(function successCallback(response) {
				$scope.allcourses = response.data.courses;
				$log.log(response.data.courses);
			}
				, function errorCallback(response) {
					$log.log(response.statusText);
				})
	};

	function updateCourse() {
		$log.log("From the update Course is called");
		$log.log($scope.course);
		
		$http({ method: "PUT", url: RESTFUL_URI + $scope.course.id, data: $scope.course })
			.then(function successCallback(response) {
				$scope.allcourses = response.data.courses;
				$log.log(response.data.courses);
			}
				, function errorCallback(response) {
					$log.log(response.statusText);
				})
	};

	function deleteCourse(id) {
		("From the deleteCourse is called with id = " + id);
		$http({ method: "DELETE", url: RESTFUL_URI + id })
			.then(function successCallback(response) {
				$scope.allcourses = response.data.courses;
				$log.log(response.data.courses);
			}
				, function errorCallback(response) {
					$log.log(response.statusText);
				})
	};

	function submit() {
		$log.log("Submit is clicked ");
		$log.log($scope.course);

		if ($scope.course.id == null) {
			$log.log("Saving New Course", $scope.course);
			createCourse();
		} else {
			updateCourse();
			$log.log("Course updated with id ", $scope.course.id);
		}
		reset();
	}

	function modify(allcourse) {
		$log.log("id to be edited", allcourse.id);
		for (var i = 0; i < $scope.allcourses.length; i++) {
			if ($scope.allcourses[i].id === allcourse.id) {
				$scope.course = angular.copy($scope.allcourses[i]);
				break;
			}
		}
	}

	function remove(allcourse) {
		$log.log("id to be deleted", allcourse);
		if ($scope.course.id === allcourse.id) {
			reset();
		}
		deleteCourse(allcourse.id);
	}

	function reset() {
		$log.log("reset is clicked");
		$scope.course = { id: null, name: "", description: "", credit: null };
		$scope.myForm.$setPristine(); //reset Form
	}

});
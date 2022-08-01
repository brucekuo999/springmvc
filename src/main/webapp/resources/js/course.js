"use strict";

var app = angular.module("app", []);

var RESTFUL_URI = "http://localhost:8080/Springmvc-registration/course/";

angular.module('app').controller('appCtrl', ['$scope', '$http', '$log', function($scope, $http, $log) {
	
	var self = this;

	self.course = { id: null, name: "", description: "", credit: null };	
	self.allcourses = [];

	self.submit = submit;
	self.modify = modify
	self.remove = remove;
	self.reset = reset;

	getAllCourses();

	function createCourse() {
		$log.log("From the createCourse is called");
		$log.log(self.course);
		
		$http({ method: "POST", url: RESTFUL_URI, data: self.course })
			.then( function successCallback(response) {
				self.allcourses = response.data;
				$log.log(response.data);
				}, function errorCallback(response) {
					$log.log(response.statusText);
				})
		};

	function getAllCourses() {
		$log.log("From the getAllCourses");
		$http({ method: "GET", url: RESTFUL_URI })
			.then( function successCallback(response) {
				self.allcourses = response.data;
				$log.log(response.data);
				}, function errorCallback(response) {
					$log.log(response.statusText);
				})
		};

	function updateCourse() {
		$log.log("From the updateCourse is called");
		$log.log(self.course);
		
		$http({ method: "PUT", url: RESTFUL_URI + self.course.id, data: self.course })
			.then( function successCallback(response) {
				self.allcourses = response.data;
				$log.log(response.data);
				}, function errorCallback(response) {
					$log.log(response.statusText);
				})
		};

	function deleteCourse(id) {
		("From the deleteCourse is called with id = " + id);
		$http({ method: "DELETE", url: RESTFUL_URI + id })
			.then( function successCallback(response) {
				self.allcourses = response.data;
				$log.log(response.data);
			    }, function errorCallback(response) {
					$log.log(response.statusText);
				})
		};

	function submit() {
		$log.log("Submit is clicked ");
		$log.log(self.course);

		if (self.course.id === null) {
			$log.log("Saving new Course", self.course);
			createCourse();
		} else {
			updateCourse();
			$log.log("Course updated with id ", self.course.id);
		}
		reset();
	}

	function modify(allcourse) {
		$log.log("id to modify", allcourse.id);
		for (var i = 0; i < self.allcourses.length; i++) {
			if (self.allcourses[i].id === allcourse.id) {
				self.course = angular.copy(self.allcourses[i]);
				break;
			}
		}
	}

	function remove(allcourse) {
		$log.log("id to delete", allcourse);
		if (self.course.id === allcourse.id) {
			reset();
		}
		deleteCourse(allcourse.id);
	}

	function reset() {
		$log.log("reset is clicked");
		self.course = { id: null, name: "", description: "", credit: null };
		$scope.myForm.$setPristine(); //reset the form
	}
	
}]);
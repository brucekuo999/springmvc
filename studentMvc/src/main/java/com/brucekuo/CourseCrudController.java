package com.brucekuo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.brucekuo.model.Course;
import com.brucekuo.service.CourseService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
@RequestMapping(value = "/course")
public class CourseCrudController {

	private static final Logger logger = LoggerFactory.getLogger(CourseCrudController.class);

	@Autowired
	CourseService courseService;
	
	// Create
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addCourse(@RequestBody Course course) {

		logger.info("Controller -> Adding course: " + course);

		if (null != course) {
			
			this.courseService.addCourse(course);
			//return new ResponseEntity<Course>(HttpStatus.OK);
			return new ResponseEntity<List<Course>>(this.courseService.listCourses(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
		}

	}

	// Read
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> retrieveAllCourses() {

		logger.info("Controller -> getAllCourses is being called");
		return new ResponseEntity<List<Course>>(this.courseService.listCourses(), HttpStatus.OK);
	}

	// Update
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable("id") Integer id) {

		logger.info("Controller -> Update Course " + id + " with " + course);

		if (null != course) {
			
			this.courseService.updateCourse(course);

			//return new ResponseEntity<Course>(HttpStatus.OK);
			return new ResponseEntity<List<Course>>(this.courseService.listCourses(), HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
			
		}

	}

	// Delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Integer id) {

		logger.info("Controller -> Deleting Course id " + id);
		this.courseService.removeCourse(id);			
		return new ResponseEntity<List<Course>>(this.courseService.listCourses(), HttpStatus.OK);

	}

}

package com.brucekuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brucekuo.dao.CourseDao;
import com.brucekuo.model.Course;
import com.brucekuo.model.CourseList;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
@RequestMapping(value = "/course")
public class CourseCrudController {

	private static final Logger logger = LoggerFactory.getLogger(CourseCrudController.class);

//		@Autowired
//		private CourseDao courseDao;

//		@Autowired
//		private StudentDao studentDao;

	// Mock up data: List<Course>

	public static HashMap<Integer, Course> mockMapCourses = new HashMap<>();
	
	private static boolean start = true;

	private static Integer counter = 25;

	public static ArrayList<Course> setMap() {

		if (start) {
			mockMapCourses.put(new Integer(0),
					new Course(new Integer(0), "Calculus I", "College Calculus Part one", new Integer(4)));
			mockMapCourses.put(new Integer(1),
					new Course(new Integer(1), "Calculus II", "College Calculus Part Two", new Integer(3)));
			mockMapCourses.put(new Integer(2),
					new Course(new Integer(2), "Calculus III", "College Calculus Part Three", new Integer(2)));
			mockMapCourses.put(new Integer(3),
					new Course(new Integer(3), "Complex numbers", "Complex numbers review", new Integer(2)));
			mockMapCourses.put(new Integer(4),
					new Course(new Integer(4), "Chemistry I", "General Chemistry I", new Integer(3)));
			mockMapCourses.put(new Integer(5),
					new Course(new Integer(5), "Calculus II", "College Calculus Part Two", new Integer(3)));
			mockMapCourses.put(new Integer(6),
					new Course(new Integer(6), "College Physics I", "Physics I", new Integer(4)));
			mockMapCourses.put(new Integer(7),
					new Course(new Integer(7), "College Physics II", "Physics II", new Integer(4)));

			start = false;

			logger.info(mockMapCourses.values().toString());
		}

		return new ArrayList(mockMapCourses.values());
	}

	// Create
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addCourse(@RequestBody Course course) {

		logger.info("Before is " + mockMapCourses);
		logger.info("Adding course " + course);

		if (null != course) {

			for (Course c : mockMapCourses.values()) {
				logger.info("This " + c);
				logger.info("That " + course);
				if (c.getName().equals(course.getName())) {
					logger.info("Course already exists");
					return new ResponseEntity<Void>(HttpStatus.CONFLICT);
				}
			}

			course.setId(counter++);
			mockMapCourses.put(course.getId(), course);

			logger.info("Course course " + course + "added!");
			logger.info("After is " + mockMapCourses);

			return new ResponseEntity<List<Course>>(setMap(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
		}

	}

	// Read
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> retrieveAllCourses() {

		logger.info("Mapping getAllCourses is being called");

		// List<Course> listCourses = this.courseDao.listCourses();
		
		return new ResponseEntity<List<Course>>(setMap(), HttpStatus.OK);
	}

	// Update
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable("id") Integer id) {

		logger.info("Before is " + mockMapCourses);
		logger.info("Update Course " + id + " with " + course);

		if (null != mockMapCourses.get(id) && null != course) {
			mockMapCourses.put(id, course);
			logger.info("Course id " + id + " updated!");
			logger.info("After is " + mockMapCourses);
			
			return new ResponseEntity<List<Course>>(setMap(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Integer id) {

		logger.info("Before is " + mockMapCourses);
		logger.info("Deleting Course id " + id);

		if (null != mockMapCourses.get(id)) {
			mockMapCourses.remove(id);
			logger.info("Course id " + id + " deleted!");
			logger.info("After is " + mockMapCourses);
			
			return new ResponseEntity<List<Course>>(setMap(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}

	}

}

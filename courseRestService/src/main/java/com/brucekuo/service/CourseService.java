package com.brucekuo.service;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brucekuo.model.Course;
import com.brucekuo.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	public CourseRepository courseRepository;

	public CourseService() {
		
	}

	public List<Course> listCourses() {
		List<Course> courseList  = courseRepository.findAll();
		return courseList;
	}

	public void addCourse(Course course)  {
		
		logger.info("Saving course :"+course);	
		courseRepository.save(course);
		
	}
	
	public void updateCourse(Course course) {
		
		logger.info("Updating course :"+course);
		courseRepository.save(course);
		
	}
	
	public void removeCourse(Integer id) {
		
		logger.info("Deleting course :"+id);
		courseRepository.deleteById(id);
		
	}

}

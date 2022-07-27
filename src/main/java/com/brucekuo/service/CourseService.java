package com.brucekuo.service;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brucekuo.dao.CourseDao;
import com.brucekuo.model.Course;

@Service
@Transactional
public class CourseService {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	public CourseDao courseDao;

	public CourseService() {
		
	}

	public List<Course> listCourses() {
		List<Course> courseList  = courseDao.listCourses();
		return courseList;
	}

	public void addCourse(Course course)  {
		
		logger.info("Saving course :"+course);	
		courseDao.addCourse(course);
		
	}
	
	public void updateCourse(Course course) {
		
		logger.info("Updating course :"+course);
		courseDao.updateCourse(course);
		
	}
	
	public void removeCourse(Integer id) {
		
		logger.info("Deleting course :"+id);
		courseDao.removeCourse(id);
		
	}

}

package com.brucekuo.service;

import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brucekuo.model.Course;

@Service
@Transactional
public class CourseService {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	private static String COURSE_SERVICES_ENDPOINT = "http://localhost:8088/course";
	
	@Autowired
	public RestTemplate restTemplate;

	public CourseService() {
		
	}

	public List<Course> listCourses() {
		
		logger.info("Service -> getting all courses");
		ResponseEntity<Course[]> response =  null;
		response = restTemplate.getForEntity(COURSE_SERVICES_ENDPOINT,Course[].class);
		logger.info("Response received from server: "+response.getBody().toString());
		List<Course> courseList  = Arrays.asList(response.getBody());
		return courseList;
	}

	public void addCourse(Course course)  {
		
		logger.info("Service -> adding course: "+course);
		
		HttpEntity<Course> request = new HttpEntity<>(course);
		//ResponseEntity<Course> response = restTemplate.exchange(COURSE_SERVICES_ENDPOINT+"/", HttpMethod.POST, request, Course.class);
		ResponseEntity<Course> response = restTemplate.exchange(COURSE_SERVICES_ENDPOINT+"/", HttpMethod.POST, request, Course.class);
		
	}
	
	public void updateCourse(Course course) {
		
		logger.info("Service -> Updating course: "+course);
		
		HttpEntity<Course> request = new HttpEntity<>(course);
		ResponseEntity<Course> response = restTemplate.exchange(COURSE_SERVICES_ENDPOINT+"/"+course.getId(), HttpMethod.PUT, request, Course.class);
		
	}
	
	public void removeCourse(Integer id) {
		
		logger.info("Service -> Deleting course: "+id);
		restTemplate.delete(COURSE_SERVICES_ENDPOINT+"/"+id);
		
	}

}

package com.brucekuo.dao;

import java.util.List;

import com.brucekuo.model.Course;

public interface CourseDao {

	public void addCourse(Course p);
	public void updateCourse(Course p);
	public List<Course> listCourses();
	public Course getCourseById(Integer id);
	public void removeCourse(Integer id);
	
}

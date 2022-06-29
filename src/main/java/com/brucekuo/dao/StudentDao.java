package com.brucekuo.dao;

import java.util.List;

import com.brucekuo.model.Student;

public interface StudentDao {

	public void addStudent(Student p);
	public void updateStudent(Student p);
	public Student getStudentById(Integer id);
	public void addCourseByStudentId(Integer StudentId, Integer courseId);
	
}

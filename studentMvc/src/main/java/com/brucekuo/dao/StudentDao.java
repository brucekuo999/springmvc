package com.brucekuo.dao;

import com.brucekuo.model.Student;

public interface StudentDao {

	public void addStudent(Student p);
	public Student getStudentById(Integer id);
	
}

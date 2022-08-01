package com.brucekuo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.brucekuo.dao.StudentDao;
import com.brucekuo.model.Course;
import com.brucekuo.model.Student;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);
		System.out.println("Student saved successfully, Student Details="+student);
		logger.info("Student saved successfully, Student details="+student);
	}

	@Override
	public Student getStudentById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();	
		
		try {
			
		Student student = (Student) session.load(Student.class, id);

		System.out.println("Student loaded successfully, Student details="+student);
		logger.info("Student loaded successfully, Student details="+student);
		return student;
		
		}catch (Exception e) {
			
			return null;
			
		}
	}
		
}

package com.brucekuo.dao.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.brucekuo.dao.StudentDao;
import com.brucekuo.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	//private static final Logger logger = LogManager.getLogger(StudentDaoImpl.class);
	private Logger logger = Logger.getLogger(StudentDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);
		System.out.println("Student saved successfully, Student Details="+student);
		logger.info("Student saved successfully, Student details="+student);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student);
		System.out.println("Student updated successfully, Student Details="+student);
		logger.info("Student updated successfully, Student details="+student);
	}
	
	@Override
	@Transactional
	public void addCourseByStudentId(Integer studentId, Integer courseId) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.update(student);
		//System.out.println("Student updated successfully, Student Details="+student);
		//logger.info("Student updated successfully, Student details="+student);
	}	

	@Override
	@Transactional
	public Student getStudentById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Student student = (Student) session.load(Student.class, id);
		System.out.println("Student loaded successfully, Student details="+student);
		logger.info("Student loaded successfully, Student details="+student);
		return student;
	}	
}

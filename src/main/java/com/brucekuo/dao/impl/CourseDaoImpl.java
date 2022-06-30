package com.brucekuo.dao.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.brucekuo.dao.CourseDao;
import com.brucekuo.model.Course;

@Repository
public class CourseDaoImpl implements CourseDao {
	
	//private static final Logger logger = LogManager.getLogger(CourseDaoImpl.class);
	private Logger logger = Logger.getLogger(CourseDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Transactional
	public void addCourse(Course p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		System.out.println("Course saved successfully, Course Details="+p);
		logger.info("Course saved successfully, Course Details="+p);
	}
	
	@Transactional
	public void updateCourse(Course p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		System.out.println("Course updated successfully, Course Details="+p);
		logger.info("Course updated successfully, Course Details="+p);
	}

	/*
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Course> listCourses() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Course> coursesList = session.createQuery("from course").list();
		for(Course p : coursesList){
			System.out.println("Course List::"+p);
		}
		return coursesList;
	}
*/
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Course> listCourses() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery(
				"CALL get_all_Courses()")
				.addEntity(Course.class);
			
			List<Course> coursesList = query.list();
			
			coursesList.forEach(System.out::println);

			return coursesList;
	}
	
	public Course getCourseById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Course p = (Course) session.load(Course.class, id);
		System.out.println("Course loaded successfully, Course details="+p);
		logger.info("Course loaded successfully, Course Details="+p);
		return p;
	}	
	

	@Transactional
	public void removeCourse(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Course p = (Course) session.load(Course.class, id);
		if(null != p){
			session.delete(p);
		}
		System.out.println("Course deleted successfully, Course details="+p);
		logger.info("Course deleted successfully, Course Details="+p);
	}

}

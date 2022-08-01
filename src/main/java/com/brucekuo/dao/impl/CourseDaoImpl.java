package com.brucekuo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.brucekuo.dao.CourseDao;
import com.brucekuo.model.Course;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Repository
public class CourseDaoImpl implements CourseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCourse(Course p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		System.out.println("Course saved successfully, Course Details="+p);
		logger.info("Course saved successfully, Course Details="+p);
	}
	
	public void updateCourse(Course p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		System.out.println("Course updated successfully, Course Details="+p);
		logger.info("Course updated successfully, Course Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> listCourses() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		logger.info("List courses using hql");
		List<Course> coursesList = session.createQuery("from Course").list();
		
		coursesList.forEach(System.out::println);
		
		return coursesList;
	}
	
/*
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> listCourses() {
		
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("List courses using stored procedure");
		Query query = session.createSQLQuery(
				"CALL get_all_Courses()")
				.addEntity(Course.class);
			
			List<Course> coursesList = query.list();
			
			coursesList.forEach(System.out::println);

			return coursesList;
	}
*/	
	
	public void removeCourse(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		/*
		String queryStr = "DELETE FROM Course where id = :id";
		Query query = session.createQuery(queryStr);
		query.setParameter("id", id);
		query.executeUpdate();
		logger.info("Course deleted successfully, Course id " + id);
		*/
		
		Course p = (Course) session.load(Course.class, id);
		if(null != p){
			session.delete(p);
			logger.info("Course deleted successfully, Course Details="+p);
		} else {
			logger.warn("Course not found for id: " + id);
		}	
	}

}

package com.brucekuo.service;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brucekuo.dao.StudentDao;
import com.brucekuo.model.Student;


@Service
@Transactional
public class StudentService {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	public StudentDao studentDao;

	public StudentService() {
		
	}

	public void addStudent(Student student)  {
		
		logger.info("Saving student :"+student);	
		studentDao.addStudent(student);
		
	}
	
	public Student getStudentById(Integer id) {
		
		logger.info("Query student :"+id);
		return studentDao.getStudentById(id);
		
	}

}


package com.brucekuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brucekuo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	

}

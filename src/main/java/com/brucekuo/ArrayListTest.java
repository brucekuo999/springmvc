package com.brucekuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.brucekuo.model.Course;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Course> mockMapCourses = new HashMap<>();
		
		mockMapCourses.put(new Integer(0), 
			new Course(new Integer(0), "Calculus I", "College Calculus Part one", new Integer(4)));
		mockMapCourses.put(new Integer(1),
			new Course(new Integer(1), "Calculus II", "College Calculus Part Two", new Integer(3)));
		mockMapCourses.put(new Integer(2),
			new Course(new Integer(2), "Calculus III", "College Calculus Part Three", new Integer(2)));
		mockMapCourses.put(new Integer(3),
			new Course(new Integer(3), "Complex numbers", "Complex numbers review", new Integer(2)));
		mockMapCourses.put(new Integer(4),
			new Course(new Integer(4), "Chemistry I", "General Chemistry I", new Integer(3)));
		mockMapCourses.put(new Integer(5),
			new Course(new Integer(5), "Calculus II", "College Calculus Part Two", new Integer(3)));
		mockMapCourses.put(new Integer(6),
			new Course(new Integer(6), "College Physics I", "Physics I", new Integer(4)));
		mockMapCourses.put(new Integer(7),
			new Course(new Integer(7), "College Physics II", "Physics II", new Integer(4)));

		System.out.println(Arrays.asList(mockMapCourses.values()));
		System.out.println(mockMapCourses.values());

	}

}

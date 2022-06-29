package com.brucekuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brucekuo.dao.CourseDao;
import com.brucekuo.dao.StudentDao;
import com.brucekuo.model.Student;
import com.brucekuo.model.Course;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@EnableWebMvc
@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

//	@Autowired
//	private CourseDao courseDao;

//	@Autowired
//	private StudentDao studentDao;
	
// Mock up data: List<Course>
	
	private Course[] courses = new Course[] {
			new Course(new Integer(0), "Calculus I", "College Calculus Part one", new Integer(4)),
			new Course(new Integer(1), "Calculus II", "College Calculus Part Two", new Integer(3)),
			new Course(new Integer(2), "Calculus III", "College Calculus Part Three", new Integer(2)),
			new Course(new Integer(3), "Linear Algebra", "Introduction to differential equations", new Integer(3)),
			new Course(new Integer(4), "Complex numbers", "Complex numbers review", new Integer(2)),
			new Course(new Integer(5), "Chemistry I", "General Chemistry I", new Integer(3)),
			new Course(new Integer(6), "College Physics I", "Physics I", new Integer(4)),
			new Course(new Integer(7), "College Physics II", "Physics II", new Integer(4)),
			};
	
	private List<Course> mockListCourses = Arrays.asList(courses);

// Mock up data: mycourses
	
	private Course[] mycourses = new Course[] {
			new Course(new Integer(0), "Calculus I", "College Calculus Part one", new Integer(4)),
			new Course(new Integer(3), "Linear Algebra", "Introduction to differential equations", new Integer(3)),
			new Course(new Integer(6), "College Physics I", "Physics I", new Integer(4))
			};
	
	private List<Course> mockMyCourses = Arrays.asList(mycourses);
	
// Mock up data: Student
	
	private Student mockStudent = new Student(1000510111, "Bruce", "Kuo", "brucekuo@spring.com", "6176687777");
	
	@RequestMapping(value = {"/", "/welcome", "/index"}, method = RequestMethod.GET)
	public String Index() {

		return "index";

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {

		model.addAttribute("student", new Student());

		return "student";

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		model.addAttribute("student", new Student());

		return "studentById";

	}
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String listcourses(Model model) {

		//List<Course> listCourses = this.courseDao.listCourses();
		
		model.addAttribute("listCourses", mockListCourses);
		
		return "course";
	}
	
	// For add and update student both
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("student") Student student, Errors errors, Model model,
			RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			return "student";
		}

//		if (student.getId() == null || student.getId() == 0) {
//			// new student, add it to system
//			this.studentDao.addStudent(student);
//		} else {
//			// existing student, update info
//			this.studentDao.updateStudent(student);
//		}

		student.setId(mockStudent.getId());
		
		redirectAttributes.addFlashAttribute("student", student);

		return "redirect:/courses";
		
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String studentById(@RequestParam Integer id, Model model) {

		//Mock up courses
		model.addAttribute("listCourses", mockListCourses);
		
		//Mock up 
		model.addAttribute("student", mockStudent);
		
		//model.addAttribute("student", model.asMap().get("student"));
		//model.addAttribute("student", this.studentDao.getStudentById(id));

		return "studentCourses";
	}

	@RequestMapping("/courses/student/add/{id}")
	public String addCourseById(@PathVariable("id") Integer id, @RequestParam Integer courseId, Model model) {

		logger.info("Your id is: " + id);
		logger.info("The courseId is: " + courseId);
		
		//Mock up courses
		model.addAttribute("listCourses", mockListCourses);
	
		logger.info("Course selected: " + mockListCourses.get(courseId));
	
		//Mock up my courses
		model.addAttribute("listMyCourses", mockMyCourses);
		
		//Mock up 
		model.addAttribute("student", mockStudent);

		//this.studentDao.addCourseByStudentId(id, courseId);
		//model.addAttribute("student", this.studentDao.getStudentById(id));
		//model.addAttribute("listCourses", this.courseDao.listCourses());

		return "studentCourses";
	}

}

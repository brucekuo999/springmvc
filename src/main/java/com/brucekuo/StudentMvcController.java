package com.brucekuo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brucekuo.dao.StudentDao;
import com.brucekuo.model.Student;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@EnableWebMvc
@Controller
public class StudentMvcController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentMvcController.class);

//	@Autowired
//	private CourseDao courseDao;

//	@Autowired
//	private StudentDao studentDao;
	
// Mock up data: Student
	
	private static Student mockStudent = new Student(1000510111, "Bruce", "Kuo", "brucekuo@spring.com", "6176687777");
	private static Integer defaultId = 1000510111;
	
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
		return "studentSignUpById";

	}
	
	// For add and update student both
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public ModelAndView addStudent(@Valid @ModelAttribute("student") Student student, Errors errors, ModelAndView mv,
			RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			mv.setViewName("student");
			return mv;
		}

//		if (student.getId() == null || student.getId() == 0) {
//			// new student, add it to system
//			this.studentDao.addStudent(student);
//		} else {
//			// existing student, update info
//			this.studentDao.updateStudent(student);
//		}
		
		logger.info(student.toString());
		student.setId(defaultId++);
		mockStudent = student;
		mv.addObject("student", mockStudent);
		mv.setViewName("manageCourses");

		return mv;
		
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String studentById(@RequestParam Integer id, Model model, RedirectAttributes redirectAttributes) {
			
		if (mockStudent.getId().equals(id)) {
			
			//Mock up 
			model.addAttribute("student", mockStudent);
			
			//model.addAttribute("student", model.asMap().get("student"));
			//model.addAttribute("student", this.studentDao.getStudentById(id));

			return "manageCourses";
		} else {
			redirectAttributes.addFlashAttribute("message", "You have entered wrong student ID");
			return "redirect:/signup";
		}

	}

}

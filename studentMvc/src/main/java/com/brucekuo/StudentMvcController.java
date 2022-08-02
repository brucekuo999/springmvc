package com.brucekuo;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.brucekuo.model.Student;
import com.brucekuo.service.StudentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@EnableWebMvc
@Controller
public class StudentMvcController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentMvcController.class);

	@Autowired
	StudentService studentService;
	
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
	
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public ModelAndView addStudent(@Valid @ModelAttribute("student") Student student, Errors errors, ModelAndView mv,
			RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			mv.setViewName("student");
			return mv;
		}

		this.studentService.addStudent(student);
		
		logger.info(student.toString());
		mv.addObject("student", student);
		mv.setViewName("manageCourses");

		return mv;
		
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String studentById(@RequestParam Integer id, Model model, RedirectAttributes redirectAttributes) {
			
		Student student = this.studentService.getStudentById(id);
		
		if (null != student){
			model.addAttribute("student", student);
			
			return "manageCourses";
		} else {
			redirectAttributes.addFlashAttribute("message", "You have entered wrong student ID");
			return "redirect:/signup";
		}

	}

}

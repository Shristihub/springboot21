package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.studentapp.exception.CityNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@Controller
@SessionAttributes("message")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String home(@ModelAttribute String message, Model model) {
		List<Student> studentList = studentService.getAll();
		model.addAttribute("studentList",studentList);
		model.addAttribute("errorMessage", message);
		return "home";
	}
	@GetMapping("/by-city")
	public String getStudentByCity(@RequestParam("city") String city, Model model) {
		List<Student> studentList = studentService.getStudentByCity(city);
		model.addAttribute("studentsByCity",studentList);
		return "home";
	}
	@GetMapping("/by-id")
	public String getById(@RequestParam("studentId")int id, Model model) {
		Student student = studentService.getStudentById(id);
		if(student.getName().equals("Joo")) {
			throw new RuntimeException("Invalid Name");
		}
		model.addAttribute("student",student);
		return "home";
	}
	
	@ExceptionHandler(CityNotFoundException.class)
	public String handleCityException(CityNotFoundException e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "redirect:/";
	}
}













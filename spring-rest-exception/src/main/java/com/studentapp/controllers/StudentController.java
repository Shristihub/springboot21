package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	@PostMapping("/students")
	Student addStudent(@RequestBody Student student){
		System.out.println(student);
		return student;
	}
	@GetMapping("/students-by-city/{city}/name/{name}")
	List<Student> getStudentByNameCity(@PathVariable("name")String start,@PathVariable("city")String city){
		return studentService.getByNameandCity(start,city);
	}
	@GetMapping("/students-by-city/{city}")
	public List<Student> getStudentByCity(@PathVariable("city")String city){
		return studentService.getStudentByCity(city);
	}
	
	@GetMapping("/students-by-name")
	List<Student> getStudentByStartingName(@RequestParam("name")String start){
		return studentService.getStudentByStartingName(start);
	}
	
	@GetMapping("/students-by-id/{id}")
	public Student getStudentById(@PathVariable("id")int id) {
		return studentService.getStudentById(id);
	}
	

}













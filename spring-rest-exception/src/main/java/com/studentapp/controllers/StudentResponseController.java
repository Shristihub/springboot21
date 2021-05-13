package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
public class StudentResponseController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> studentList = studentService.getAll();
		ResponseEntity<List<Student>> entity= new ResponseEntity<>(studentList,HttpStatus.OK);
		return entity;
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		HttpHeaders header = new HttpHeaders();
		header.add("details", "Passing One Student Details");
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(student);
	}
	@GetMapping("/students-by-city/{city}/name/{name}")
	public ResponseEntity<List<Student>> getStudentByNameCity(@PathVariable("name")String start,@PathVariable("city")String city){
		List<Student> studentList = studentService.getByNameandCity(start,city);
		return ResponseEntity.ok(studentList);
	}
	@GetMapping("/students-by-city/{city}")
	public ResponseEntity<List<Student>> getStudentByCity(@PathVariable("city")String city){
		HttpHeaders headers = new HttpHeaders();
		headers.add("details", "Student Details By City");
		headers.add("message", "Great day");
		List<Student> studentList = studentService.getStudentByCity(city);
		return ResponseEntity.ok().headers(headers).body(studentList);
	}
	
	@GetMapping("/students-by-name")
	public ResponseEntity<List<Student>> getStudentByStartingName(@RequestParam("name")String start){
		HttpHeaders headers = new HttpHeaders();
		headers.add("details", "Student Details By starting name");
		headers.add("message", "Data from API");
		List<Student> studentList = studentService.getStudentByStartingName(start);
		return new ResponseEntity<>(studentList,headers,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/students-by-id/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id")int id) {
		Student student =  studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}
	

}













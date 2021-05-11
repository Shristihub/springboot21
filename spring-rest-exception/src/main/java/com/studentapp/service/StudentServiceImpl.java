package com.studentapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.studentapp.model.Student;
@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> getStudentByCity(String city) {
		List<Student> studentList = 
				studentDetails()
				.stream()
				.filter(student -> student.getCity().equals(city))
				.collect(Collectors.toList());
		return studentList;
	 }
	@Override
	public Student getStudentById(int id) {
		return studentDetails()
				.stream()
				.filter(student -> student.getStudentId() == id)
				.findFirst()
				.orElse(new Student());
	}
	@Override
	public List<Student> getAll() {
		return studentDetails();
	}
	private List<Student> studentDetails() {
		return Arrays.asList(
				new Student("Jack", 10, "Jaipur"), 
				new Student("Robin", 11, "Delhi"),
				new Student("Kate", 12, "Goa"), 
				new Student("Rohan", 13, "Jaipur"), 
				new Student("Joo", 14, "Agra"),
				new Student("Henry", 15, "Goa"));
	}
	@Override
	public List<Student> getStudentByStartingName(String start) {
		List<Student> studentList = 
				studentDetails()
				.stream()
				.filter(student -> student.getName().contains(start))
				.collect(Collectors.toList());
		return studentList;
	}
	@Override
	public List<Student> getByNameandCity(String start, String city) {
		List<Student> studentList = 
				studentDetails()
				.stream()
				.filter(student -> student.getCity().equals(city))
				.filter(student -> student.getName().contains(start))
				.collect(Collectors.toList());
		return studentList;
	}

	
}

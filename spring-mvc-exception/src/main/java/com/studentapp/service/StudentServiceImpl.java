package com.studentapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.studentapp.exception.CityNotFoundException;
import com.studentapp.exception.IDNotFoundException;
import com.studentapp.model.Student;
@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> getStudentByCity(String city) throws CityNotFoundException {
		List<Student> studentList = 
				studentDetails()
				.stream()
				.filter(student -> student.getCity().equals(city))
				.collect(Collectors.toList());
		if(studentList.isEmpty())
			throw new CityNotFoundException("Student with this City not found ");
		return studentList;
	 }
	@Override
	public Student getStudentById(int id) throws IDNotFoundException {
		return studentDetails()
				.stream()
				.filter(student -> student.getStudentId() == id)
				.findFirst()
				.orElseThrow(()-> new IDNotFoundException("Invalid Id"));
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

	
}

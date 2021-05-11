package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Student;

public interface StudentService {
	List<Student> getAll();
	List<Student> getStudentByCity(String city);
	List<Student> getStudentByStartingName(String start);
	Student getStudentById(int id) ;
	List<Student> getByNameandCity(String start, String city);

}

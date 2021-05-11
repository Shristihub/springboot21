package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Student;

public interface StudentService {
	void addStudent(Student student);
	void updateStudent(int studentId,String city);
	void deleteStudent(int studentId);
	List<Student> getAllStudents();
	List<Student> getStudentsByCity(String city);
	Student getStudentById(int id);
	String getNameById(int id);
}

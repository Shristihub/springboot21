package com.studentapp.dao;

import java.util.List;

import com.studentapp.model.Student;

public interface IStudent {
	void addOneStudent(Student student);
	void updateOneStudent(int studentId,String city);
	void deleteOneStudent(int studentId);
	List<Student> findAllStudents();
	List<Student> findStudentsByCity(String city);
	Student findStudentById(Integer id);
	String findNameById(int id);

}

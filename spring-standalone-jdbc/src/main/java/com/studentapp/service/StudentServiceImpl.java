package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.dao.IStudent;
import com.studentapp.model.Student;

//studentServiceImpl
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	IStudent studentDAO ;
	@Override
	public void addStudent(Student student) {
		studentDAO.addOneStudent(student);
	}

	@Override
	public void updateStudent(int studentId, String city) {
		studentDAO.updateOneStudent(studentId, city);
	}

	@Override
	public void deleteStudent(int studentId) {
		studentDAO.deleteOneStudent(studentId);		
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDAO.findAllStudents();
	}

	@Override
	public List<Student> getStudentsByCity(String city) {
		return studentDAO.findStudentsByCity(city);
	}

	@Override
	public Student getStudentById(int id) {
		return studentDAO.findStudentById(id);
	}

	@Override
	public String getNameById(int id) {
		return studentDAO.findNameById(id);
	}

}

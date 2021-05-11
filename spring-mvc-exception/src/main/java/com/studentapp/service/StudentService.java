package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.CityNotFoundException;
import com.studentapp.exception.IDNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {
	List<Student> getAll();
	List<Student> getStudentByCity(String city)throws CityNotFoundException;
	Student getStudentById(int id) throws IDNotFoundException;

}

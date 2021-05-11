package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@SpringBootApplication
public class SpringStandaloneJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringStandaloneJdbcApplication.class, args);
	}

	@Autowired
	StudentService studentService;

	@Override
	public void run(String... args) throws Exception {

		Student student = new Student("Maran", 16, "Ooty", 88875678);
//		 studentService.addStudent(student);
		studentService.getAllStudents().forEach(System.out::println);
		System.out.println();
		studentService.getStudentsByCity("Ooty").forEach(System.out::println);
		System.out.println();
		Student stud = studentService.getStudentById(12);
		System.out.println(stud);
		studentService.updateStudent(12, "Goa");
		System.out.println(studentService.getNameById(16));
	}

}

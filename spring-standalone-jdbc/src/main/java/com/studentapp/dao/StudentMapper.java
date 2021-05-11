package com.studentapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.studentapp.model.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		String name = rs.getString("name");
		String city = rs.getString("city");
		long mobile = rs.getLong("mobile");
		int studentId = rs.getInt("stud_id");
		Student student = new Student(name, studentId, city, mobile);
		return student;
	}

}

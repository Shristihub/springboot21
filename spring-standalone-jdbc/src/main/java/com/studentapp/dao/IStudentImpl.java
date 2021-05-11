package com.studentapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public class IStudentImpl implements IStudent {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setDatasource(DataSource datasource) {
		jdbcTemplate.setDataSource(datasource);
	}

	@Override
	public void addOneStudent(Student student) {
		String sql = "insert into mstudent values(?,?,?,?)";
		Object[] studentArray = { student.getStudentName(), student.getStudentId(), student.getMobile(),
				student.getCity() };
		jdbcTemplate.update(sql, studentArray);
	}

	@Override
	public void updateOneStudent(int studId, String city) {
		String sql = "update mstudent set city=? where stud_Id=?";
//		Object[] studentArray = {city,studId};
//		jdbcTemplate.update(sql,studentArray);
		jdbcTemplate.update(sql, city, studId);

	}

	@Override
	public void deleteOneStudent(int studentId) {
		String sql = "delete from mstudent where stud_Id=?";
		jdbcTemplate.update(sql, studentId);

	}

	@Override
	public List<Student> findAllStudents() {
		String sql = "select * from mstudent";
		StudentMapper mapper = new StudentMapper();
		List<Student> studentList = jdbcTemplate.query(sql, mapper);
		return studentList;
	}

	@Override
	public List<Student> findStudentsByCity(String mcity) {
		String sql = "select * from mstudent where city = ?";
		// called as anonymous innerclass
//		List<Student> studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {
//
//			@Override
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setStudentName(rs.getString("name"));
//				student.setCity(rs.getString("city"));
//				student.setMobile(rs.getLong("mobile"));
//				student.setStudentId(rs.getInt("stud_id"));
//				return student;
//			}
//		}, mcity);
		
		// Lambda expressions
		List<Student> studentList = jdbcTemplate.query(sql,(rs,rowNum)->{
			Student student = new Student();
			student.setStudentName(rs.getString("name"));
			student.setCity(rs.getString("city"));
			student.setMobile(rs.getLong("mobile"));
			student.setStudentId(rs.getInt("stud_id"));
			return student;
		},mcity);
		return studentList;
	}

	@Override
	public Student findStudentById(Integer studId) {
		String sql = "select * from mstudent where stud_id = ?";
		StudentMapper mapper  = new StudentMapper();
	//	Student student = jdbcTemplate.queryForObject(sql,mapper,studId);
		Student student = jdbcTemplate.queryForObject(sql,Student.class,studId);
		return student;
	}

	@Override
	public String findNameById(int id) {
		String sql = "select name from mstudent where stud_Id = ?";
		String name = jdbcTemplate.queryForObject(sql,String.class,id);
		return name;
	}

}

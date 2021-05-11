package com.studentapp.model;

public class Student {
	private String studentName;
	private Integer studentId;
	private String city;
	private long mobile;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String studentName, Integer studentId, String city, long mobile) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.city = city;
		this.mobile = mobile;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", city=" + city + ", mobile=" + mobile + "]";
	}
	
	

}

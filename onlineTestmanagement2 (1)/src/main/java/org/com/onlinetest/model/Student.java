package org.com.onlinetest.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private BigInteger StudentId;
	private String StudentName;
	private String studentPassword;
	
	@OneToOne
	private Assessment testId;
	
	public Assessment getTestId() {
		return testId;
	}
	public void setTestId(Assessment testId) {
		this.testId = testId;
	}
	public BigInteger getStudentId() {
		return StudentId;
	}
	public void setStudentId(BigInteger studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	Student()
	{
		
	}
	public Student(BigInteger studentId, String studentName, String studentPassword) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		this.studentPassword = studentPassword;
	}
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", studentPassword="
				+ studentPassword + "]";
	}
	
	
}

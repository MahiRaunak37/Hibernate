package com.hibernate.state;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state_student_table")
public class Student {
	@Id
	private int studentId;
	private String studentName;
	private String studentCity;
	
	@OneToOne
	private Certificates certificates;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	public Certificates getCertificates() {
		return certificates;
	}
	public void setCertificates(Certificates certificates) {
		this.certificates = certificates;
	}
	public Student(int studentId, String studentName, String studentCity, Certificates certificates) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCity = studentCity;
		this.certificates = certificates;
	}
	public Student() {
		super();
	}
	
}

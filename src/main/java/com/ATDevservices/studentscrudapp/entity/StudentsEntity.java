package com.ATDevservices.studentscrudapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Students")
public class StudentsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	@Column(name = "Contact", length = 10)
	private long studentContact;
}

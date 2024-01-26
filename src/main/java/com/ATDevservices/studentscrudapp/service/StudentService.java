package com.ATDevservices.studentscrudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ATDevservices.studentscrudapp.entity.StudentsEntity;
import com.ATDevservices.studentscrudapp.repository.StudentRepository;
@Service


public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	

	public StudentsEntity insertStudent(StudentsEntity entity) {
		StudentsEntity student = repository.save(entity);
		
		if(student != null) {
			return student;
		}
		else {
			return null;
		}
	}


	public List<StudentsEntity> getAllStudents() {
		List<StudentsEntity> students = repository.findAll();
		
		if(!students.isEmpty()) {
			return students;
		}
		else {
			return null;
		}
	}


	public StudentsEntity serchStudent(long id) {
		StudentsEntity student = repository.findById(id);
		if(student != null) {
			return student;
		}
		else {
			return null;
		}
		
		
	}


	public StudentsEntity deleteStudent(long id) {
		StudentsEntity student = repository.findById(id);
		
		if(student!= null) {
			repository.delete(student);
			return student;
		}
		return null;
	}


	public StudentsEntity updateStudent(StudentsEntity entity) {
		long sid = entity.getStudentId();
		StudentsEntity student = repository.findById(sid);
		
		if(student!= null) {
			student.setStudentName(entity.getStudentName());
			student.setStudentEmail(entity.getStudentEmail());
			student.setStudentAddress(entity.getStudentAddress());
			student.setStudentContact(entity.getStudentContact());
			
			StudentsEntity updatedStudent = repository.save(student);
			
			return updatedStudent;
		}
		
		return null;
	}

}

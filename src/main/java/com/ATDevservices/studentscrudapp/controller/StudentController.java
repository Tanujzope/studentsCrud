package com.ATDevservices.studentscrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ATDevservices.studentscrudapp.entity.StudentsEntity;
import com.ATDevservices.studentscrudapp.response.StudentResponse;
import com.ATDevservices.studentscrudapp.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	//API address:- http://localhost:8086/insertStudent    method=post
	@PostMapping("/insertStudent")
	public ResponseEntity<StudentResponse> insertStudent(@RequestBody StudentsEntity entity){
		StudentsEntity student = service.insertStudent(entity);
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student Added Successfully...", student, null), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Failed to insert, Something went wrong", null, null), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	
	
	//API Address:-   http://localhost:8086/getAllStudents     method=get
	@GetMapping("/getAllStudents")
	public ResponseEntity<StudentResponse> getAllStudents(){
		List<StudentsEntity> students = service.getAllStudents();
		
		if(students != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Students Data Fetched Succesfully...", null, students), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<StudentResponse>(new StudentResponse("No Students found!!!", null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	//API Address:-   http://localhost:8086/searchStudent?id={}     method=get
	@GetMapping("/searchStudent")
	public ResponseEntity<StudentResponse> searchStudent(@RequestParam long id){
		StudentsEntity student = service.serchStudent(id);
		
		if(student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student Found...", student, null), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student Record not Found!!!", null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	//API Address:-   http://localhost:8086/searchStudent?id={}     method=delete
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<StudentResponse> deleteStudent(@RequestParam long id){
		StudentsEntity student = service.deleteStudent(id);
		if(student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student Removed Successfully", student, null), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Failed to remove Student!!!", null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	//API Address:-   http://localhost:8086/updateStudent     method=put
	@PutMapping("/updateStudent")
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentsEntity entity){
		StudentsEntity student = service.updateStudent(entity);
		
		if(student!= null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student Updated Successfully", student, null), HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student Updation Failed!!!", null, null), HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
	
	
	
	
}

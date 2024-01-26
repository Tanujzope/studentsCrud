package com.ATDevservices.studentscrudapp.response;

import java.util.List;

import com.ATDevservices.studentscrudapp.entity.StudentsEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StudentResponse {
	
	private String message;
	private StudentsEntity student;
	private List<StudentsEntity> students;
}

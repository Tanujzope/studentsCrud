package com.ATDevservices.studentscrudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ATDevservices.studentscrudapp.entity.StudentsEntity;

public interface StudentRepository extends JpaRepository<StudentsEntity, Long> {
	
	StudentsEntity findById(long id);

}

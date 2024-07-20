package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.StudentSection;
import com.example.demo.entities.User;

public interface StudentSectionRepository extends CrudRepository<StudentSection, String>{
	
	
}

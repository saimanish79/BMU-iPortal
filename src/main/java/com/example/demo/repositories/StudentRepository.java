package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Student;
import com.example.demo.entities.User;

public interface StudentRepository extends CrudRepository<Student, String>{

	Student findByUser2(User user);
}

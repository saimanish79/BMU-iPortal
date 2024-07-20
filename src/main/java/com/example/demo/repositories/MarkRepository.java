package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Mark;
import com.example.demo.entities.User;

public interface MarkRepository extends CrudRepository<Mark, Long>{

	Iterable<Mark> findByUser(User u);
	
}

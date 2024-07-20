package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.User;

public interface GatepassRepository extends CrudRepository<GatepassTable, Long>{
	
	public List<GatepassTable> findByUser2(User student);

	public List<GatepassTable> findByStatus(String string);

	public List<GatepassTable> findByStatusOrStatus(String string, String string2);

}
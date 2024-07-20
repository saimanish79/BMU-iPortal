package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.Cours;
import com.example.demo.entities.User;

public interface AttendanceRepository extends CrudRepository<Attendance, Long>{

	Iterable<Attendance> findByUser(User u);
	
	Iterable<Attendance> findByUserAndCours(User user,Cours course);

	Iterable<Attendance> findByUserAndCoursAndStatus(User user,Cours course,String status);
}

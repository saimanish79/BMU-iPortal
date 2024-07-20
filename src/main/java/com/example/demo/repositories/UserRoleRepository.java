package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.User;
import com.example.demo.entities.UserRole;



public interface UserRoleRepository extends CrudRepository<UserRole, BigDecimal> {

	public List<UserRole> findByUser(User user);
}

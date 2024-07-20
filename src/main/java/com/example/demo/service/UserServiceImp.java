package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImp implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.findByUserId(username);
	return new UserDetailsImp(user);
}

			

}

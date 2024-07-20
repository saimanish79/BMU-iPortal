package com.example.demo.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.User;

public class UserDetailsImp implements UserDetails{

	
	private User user;
	public UserDetailsImp(User user){
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities= new HashSet<GrantedAuthority>();
		
		/*List<Role> list = user.getRoles();
		
		Iterator<Role> iterator = list.iterator();
		while(iterator.hasNext()){
			authorities.add(new SimpleGrantedAuthority(iterator.next().toString()));
		}*/
		 
		 return authorities;
	}
	
	@Override
	public String getUsername() {
	return user.getUserId();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}


package com.taskmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.taskmanager.entities.User;
import com.taskmanager.repository.UserRepo;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=repo.getUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found..");
		}
		
		UserCustomDetails userCustomDetails = new UserCustomDetails(user);
		return userCustomDetails;
	}

}

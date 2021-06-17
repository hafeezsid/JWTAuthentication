package com.ecommerce.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> fetchAllUser() {

		return userRepository.findAll();
	}

	public User findByUsername(String userId) {

		return userRepository.findByUsername(userId);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
		
	}

	
	
}

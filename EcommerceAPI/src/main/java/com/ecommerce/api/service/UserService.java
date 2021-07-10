package com.ecommerce.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProfileImageService profileImageService;

	@Autowired
	UserRepository userRepo;

	public String getLoggedInUsername() {
		return getAuthentication().getName();

	}
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public User getLoggedInUserDetails() {
		String username = getAuthentication().getName();
		return userRepo.findByUsername(username);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> fetchAllUser() {

		return userRepository.findAll();
	}

	public User findByUsername(String userId) {

		return userRepository.findByUsername(userId);
	}
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public User updateUser(User user) {
		return userRepository.save(user);

	}


}

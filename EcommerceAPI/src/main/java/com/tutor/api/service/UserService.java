package com.tutor.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tutor.api.entity.User;
import com.tutor.api.repository.UserRepository;

@Service
public class UserService {


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
		return userRepo.save(user);
	}

	public List<User> fetchAllUser() {

		return userRepo.findAll();
	}

	public User findByUsername(String userId) {

		return userRepo.findByUsername(userId);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public User updateUser(User user) {
		return userRepo.save(user);

	}
	
	public User findByUserIdAndType(long userId, String type) {
		return userRepo.findByUserIdAndType(userId, type);
	}


}

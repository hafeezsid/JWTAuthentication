package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String userId)
	{
		return userRepo.findByUsername(userId);
	}
	
	@GetMapping("/login")
	public User login() {
		return null;
	}
	

}

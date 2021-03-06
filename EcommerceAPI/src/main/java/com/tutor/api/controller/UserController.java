package com.tutor.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tutor.api.entity.User;
import com.tutor.api.exceptionHandler.ApplicationException;
import com.tutor.api.exceptionHandler.BadRequest;
import com.tutor.api.exceptionHandler.CustomException;
import com.tutor.api.exceptionHandler.ResourceAlreadyExist;
import com.tutor.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.fetchAllUser();
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String userId)
	{
		return userService.findByUsername(userId);
	}
	
	
	/*
	 * @PostMapping("/register") public ResponseEntity<User>
	 * registerUser(@RequestBody User user){ try { User
	 * savedUser=userService.findByUsername(user.getEmail()); if(savedUser!=null) {
	 * throw new
	 * ResourceAlreadyExist("An account for that username/email already exists."); }
	 * if(user==null) { throw new
	 * BadRequest("Request doesnot contain enough information"); } String []at=
	 * {"ROLE_USER"}; user.setAuthorities(at); User
	 * newUser=userService.saveUser(user); return new ResponseEntity<User>(newUser,
	 * HttpStatus.OK); } catch (Exception e) { throw new
	 * CustomException("Error occurred while registering user."); }
	 * 
	 * }
	 */
	
	
	@GetMapping("/login")
	public User login() {
		return null;
	}
	
	
	

}

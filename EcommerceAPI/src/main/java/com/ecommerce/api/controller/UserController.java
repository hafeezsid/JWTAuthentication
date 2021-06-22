package com.ecommerce.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.entity.ProfileImage;
import com.ecommerce.api.exceptionHandler.ApplicationException;
import com.ecommerce.api.exceptionHandler.BadRequest;
import com.ecommerce.api.exceptionHandler.CustomException;
import com.ecommerce.api.exceptionHandler.ResourceAlreadyExist;
import com.ecommerce.api.repository.ProfileImageRepository;
import com.ecommerce.api.repository.UserRepository;
import com.ecommerce.api.service.UserService;

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
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		try {
		User savedUser=userService.findByUsername(user.getEmail());
		if(savedUser!=null)
		{
			throw new ResourceAlreadyExist("An account for that username/email already exists.");
		}
		if(user==null) {
			throw new BadRequest("Request doesnot contain enough information");
		}
		String []at= {"ROLE_USER"};
		user.setAuthorities(at);
		User newUser=userService.saveUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
		}
		catch (Exception e) {
			throw new CustomException("Error occurred while registering user.");
		}
		
	}
	
	@PostMapping("/uploadImage")
	public ResponseEntity<String> uploadProfileImage(
			@RequestParam("id")  String id,@RequestParam("image") MultipartFile file)
	{	
		byte image[];
		try {
			image = file.getBytes();
			userService.saveProfileImage(id, image);
			return new ResponseEntity<String>("true",HttpStatus.OK);
		} catch (Exception e) {
			throw new ApplicationException("Error while uploading image");
		}
	}
	
	@GetMapping("/login")
	public User login() {
		return null;
	}
	

}

package com.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.exceptionHandler.ResourceNotFoundException;
import com.ecommerce.api.entity.ProfileImage;
import com.ecommerce.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProfileImageService profileImageService;
	
	

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

	public User saveProfileImage(String id, byte[] image) {
		User user=userRepository.findByUsername(id);
				
		if(user!=null) {
			ProfileImage photoObj=new ProfileImage();
			photoObj.setImage(image);
			user.setProfileImage(photoObj);
			return userRepository.save(user);
		}
		else {
			throw new ResourceNotFoundException("User Not Found");
		}
	}

	
	
}

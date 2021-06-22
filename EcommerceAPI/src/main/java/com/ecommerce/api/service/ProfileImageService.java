package com.ecommerce.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.repository.ProfileImageRepository;

@Service
public class ProfileImageService {

	@Autowired
	ProfileImageRepository profileImageRepository;
	
	
	
}

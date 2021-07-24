package com.tutor.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.api.repository.ProfileImageRepository;

@Service
public class ProfileImageService {

	@Autowired
	ProfileImageRepository profileImageRepository;
	
	
	
}

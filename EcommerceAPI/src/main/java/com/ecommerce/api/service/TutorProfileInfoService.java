package com.ecommerce.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.TutorProfileInfo;
import com.ecommerce.api.repository.TutorProfileInfoRepository;

@Service
public class TutorProfileInfoService {
	
	@Autowired
	TutorProfileInfoRepository tutorProfileInfoRepo;

	public TutorProfileInfo saveTutorProfileInfo(TutorProfileInfo infoObj) {
		return tutorProfileInfoRepo.save(infoObj);
		
	}

}

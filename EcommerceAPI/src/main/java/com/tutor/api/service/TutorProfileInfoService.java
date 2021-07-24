package com.tutor.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.api.entity.TutorProfileInfo;
import com.tutor.api.repository.TutorProfileInfoRepository;

@Service
public class TutorProfileInfoService {
	
	@Autowired
	TutorProfileInfoRepository tutorProfileInfoRepo;

	public TutorProfileInfo saveTutorProfileInfo(TutorProfileInfo infoObj) {
		return tutorProfileInfoRepo.save(infoObj);
		
	}

}

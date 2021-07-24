package com.tutor.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tutor.api.entity.TutorPersonalInfo;
import com.tutor.api.repository.UserLanguaugeRepository;

@Service
public class UserLanguageService {

	@Autowired
	UserLanguaugeRepository userLanguageRepo;

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public void deleteLanguage(TutorPersonalInfo tutorPersonalInfo) {
		userLanguageRepo.deleteByTutorPersonalInfo(tutorPersonalInfo);
	}
}

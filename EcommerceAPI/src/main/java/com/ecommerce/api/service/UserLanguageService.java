package com.ecommerce.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.api.entity.TutorPersonalInfo;
import com.ecommerce.api.repository.UserLanguaugeRepository;

@Service
public class UserLanguageService {

	@Autowired
	UserLanguaugeRepository userLanguageRepo;

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public void deleteLanguage(TutorPersonalInfo tutorPersonalInfo) {
		userLanguageRepo.deleteByTutorPersonalInfo(tutorPersonalInfo);
	}
}

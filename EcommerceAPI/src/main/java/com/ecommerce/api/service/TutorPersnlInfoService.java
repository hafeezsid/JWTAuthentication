package com.ecommerce.api.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.TutorPersonalInfo;
import com.ecommerce.api.repository.TutorPersonalInfoRepository;

@Service
public class TutorPersnlInfoService {
	
	@Autowired
	TutorPersonalInfoRepository tutorPersonalInfoRepo;
	@Transactional(value = TxType.REQUIRED)
	public TutorPersonalInfo saveTutorPersonalInfo(TutorPersonalInfo infoObj) {
		return tutorPersonalInfoRepo.save(infoObj);
	}

}

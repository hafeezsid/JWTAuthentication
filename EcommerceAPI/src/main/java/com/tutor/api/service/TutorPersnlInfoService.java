package com.tutor.api.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.api.entity.TutorPersonalInfo;
import com.tutor.api.repository.TutorPersonalInfoRepository;

@Service
public class TutorPersnlInfoService {
	
	@Autowired
	TutorPersonalInfoRepository tutorPersonalInfoRepo;
	@Transactional(value = TxType.REQUIRED)
	public TutorPersonalInfo saveTutorPersonalInfo(TutorPersonalInfo infoObj) {
		return tutorPersonalInfoRepo.save(infoObj);
	}

}

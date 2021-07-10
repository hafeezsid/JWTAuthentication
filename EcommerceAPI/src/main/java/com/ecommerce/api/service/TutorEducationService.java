package com.ecommerce.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.TutorEducation;
import com.ecommerce.api.repository.TutorEducationRepository;

@Service
public class TutorEducationService {
	
	@Autowired
	TutorEducationRepository tutorEducationRepository;

	public TutorEducation saveEducation(TutorEducation education) {
		return tutorEducationRepository.save(education);
		
	}

	public void deleleTutorEducationById(long tutorEducatioId) {
		tutorEducationRepository.deleteById(tutorEducatioId);	
	}

}

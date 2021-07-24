package com.tutor.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.api.entity.TutorEducation;
import com.tutor.api.repository.TutorEducationRepository;

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

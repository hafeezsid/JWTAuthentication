package com.ecommerce.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.TutorExperience;
import com.ecommerce.api.repository.TutorExperienceRepository;

@Service
public class TutorExperienceService {
	
	@Autowired
	TutorExperienceRepository tutorExperienceRepository ;

	public TutorExperience saveExperience(TutorExperience tutorExperience) {
		return tutorExperienceRepository.save(tutorExperience);
	}

	public void deleleTutorExperienceById(long tutorExperienceId) {
		tutorExperienceRepository.deleteById(tutorExperienceId);
	}

}

package com.tutor.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.api.entity.TutorExperience;
import com.tutor.api.repository.TutorExperienceRepository;

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

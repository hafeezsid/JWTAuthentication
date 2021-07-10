package com.ecommerce.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.TutorCertificate;
import com.ecommerce.api.repository.TutorCertificateRepository;

@Service
public class TutorCertificateService {

	@Autowired
	TutorCertificateRepository tutorCertificateRepository;
	
	public TutorCertificate saveCertificate(TutorCertificate tutorCertificate) {
		return tutorCertificateRepository.save(tutorCertificate);
	}

	public void deleleTutorCertificateById(long tutorCertificateId) {
		tutorCertificateRepository.deleteById(tutorCertificateId);
		
	}

}

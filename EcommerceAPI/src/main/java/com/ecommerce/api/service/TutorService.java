package com.ecommerce.api.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.api.entity.TutorCertificate;
import com.ecommerce.api.entity.TutorEducation;
import com.ecommerce.api.entity.TutorExperience;
import com.ecommerce.api.entity.TutorPersonalInfo;
import com.ecommerce.api.entity.TutorProfile;
import com.ecommerce.api.entity.TutorProfileInfo;
import com.ecommerce.api.entity.User;
import com.ecommerce.api.repository.TutorProfileRepository;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public class TutorService {

	@Autowired
	TutorEducationService tutorEducationService;
	
	@Autowired
	TutorExperienceService tutorExperienceService;
	
	@Autowired
	TutorCertificateService tutorCertificateService;
	
	@Autowired
	TutorPersnlInfoService tutorPersonalInfoService;
	
	@Autowired
	TutorProfileInfoService tutorProfileInfoService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserLanguageService userLanguageService;
	
	@Autowired
	TutorProfileRepository tutorProfileRepo;
	public TutorEducation saveEducation(TutorEducation education) {
		return tutorEducationService.saveEducation(education);
	}
	public TutorExperience saveExperience(TutorExperience tutorExperience) {
		
		return tutorExperienceService.saveExperience(tutorExperience);
	}
	public TutorCertificate saveCertificate(TutorCertificate tutorCertificate) {
		return tutorCertificateService.saveCertificate(tutorCertificate);
	}
	public TutorProfile saveTutorProfileWithImage(TutorProfile tutorProfile) {
		return tutorProfileRepo.save(tutorProfile);
	}
	public TutorPersonalInfo saveTutorPersonalInfo(TutorPersonalInfo infoObj) {
		return tutorPersonalInfoService.saveTutorPersonalInfo(infoObj);
		
	}
	public TutorProfile fetchTutorProfileByUser(User user) {
			return tutorProfileRepo.findByUser(user);
	}
	public void deleteTutorLanguages(TutorPersonalInfo tutorPersonalInfo) {
		 userLanguageService.deleteLanguage(tutorPersonalInfo);
		
	}
	public TutorPersonalInfo saveTutorPersonalInfo(TutorPersonalInfo infoObj, User user) throws Exception {
		TutorProfile tutorP=fetchTutorProfileByUser(user);
		if(tutorP!=null && tutorP.getTutorPersonalInfo()!=null) {
			infoObj.setTutorPersonalInfoId(tutorP.getTutorPersonalInfo().getTutorPersonalInfoId());
			deleteTutorLanguages(tutorP.getTutorPersonalInfo());
		}
		infoObj.setTutorProfile(tutorP);
		infoObj.getLanguageList().stream().forEach(e->e.setTutorPersonalInfo(infoObj));
		tutorPersonalInfoService.saveTutorPersonalInfo(infoObj);
		user.setIsRegFirstStepComplete(true);
		userService.updateUser(user);
		return infoObj;
		
	}
	
	public TutorProfileInfo saveTutorProfileInfo(TutorProfileInfo infoObj, User user) throws Exception {
		TutorProfile tutorP=fetchTutorProfileByUser(user);
		if(tutorP!=null && tutorP.getTutorProfileInfo()!=null) {
			infoObj.setTutorProfileInfoId(tutorP.getTutorProfileInfo().getTutorProfileInfoId());
			//deleteTutorLanguages(tutorP.getTutorProfileInfo());
		}
		infoObj.setTutorProfile(tutorP);
		infoObj.getTutorSubjects().stream().forEach(e->e.setTutorProfileInfo(infoObj));
		
		tutorProfileInfoService.saveTutorProfileInfo(infoObj);
		user.setIsRegSecondStepComplete(true);
		userService.updateUser(user);
		return infoObj;
	}
	public void saveTutorProfileInfo(TutorProfileInfo tpi) {
		tutorProfileInfoService.saveTutorProfileInfo(tpi);
	}
	public void deleleTutorEducationById(long tutorEducatioId) {
		tutorEducationService.deleleTutorEducationById(tutorEducatioId);
		
	}
	public void deleleTutorCertificateById(long tutorCertificateId) {
		tutorCertificateService.deleleTutorCertificateById(tutorCertificateId);
		
	}
	public void deleleTutorExperienceById(long tutorExperienceId) {
		tutorExperienceService.deleleTutorExperienceById(tutorExperienceId);
		
	}


}

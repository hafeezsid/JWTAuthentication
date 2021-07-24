package com.tutor.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutor.api.constants.AppConstants;
import com.tutor.api.dto.TutorListDto;
import com.tutor.api.dto.TutorListViewDto;
import com.tutor.api.dto.TutorPersonalInfoDto;
import com.tutor.api.dto.TutorProfileInfoDto;
import com.tutor.api.entity.TutorCertificate;
import com.tutor.api.entity.TutorEducation;
import com.tutor.api.entity.TutorExperience;
import com.tutor.api.entity.TutorPersonalInfo;
import com.tutor.api.entity.TutorProfile;
import com.tutor.api.entity.TutorProfileInfo;
import com.tutor.api.entity.User;
import com.tutor.api.exceptionHandler.ApplicationException;
import com.tutor.api.exceptionHandler.ResourceNotFoundException;
import com.tutor.api.repository.TutorProfileRepository;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class TutorService {

	Logger logger = LoggerFactory.getLogger(TutorService.class);

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
	ObjectMapper objectMapper;

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
		TutorProfile tutorP = fetchTutorProfileByUser(user);
		if (tutorP != null && tutorP.getTutorPersonalInfo() != null) {
			infoObj.setTutorPersonalInfoId(tutorP.getTutorPersonalInfo().getTutorPersonalInfoId());
			deleteTutorLanguages(tutorP.getTutorPersonalInfo());
		}
		infoObj.setTutorProfile(tutorP);
		infoObj.getLanguageList().stream().forEach(e -> e.setTutorPersonalInfo(infoObj));
		tutorPersonalInfoService.saveTutorPersonalInfo(infoObj);
		user.setIsRegFirstStepComplete(true);
		userService.updateUser(user);
		return infoObj;

	}

	public TutorProfileInfo saveTutorProfileInfo(TutorProfileInfo infoObj, User user) throws Exception {
		TutorProfile tutorP = fetchTutorProfileByUser(user);
		if (tutorP != null && tutorP.getTutorProfileInfo() != null) {
			infoObj.setTutorProfileInfoId(tutorP.getTutorProfileInfo().getTutorProfileInfoId());
			// deleteTutorLanguages(tutorP.getTutorProfileInfo());
		}
		infoObj.setTutorProfile(tutorP);
		infoObj.getTutorSubjects().stream().forEach(e -> e.setTutorProfileInfo(infoObj));

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

	@Transactional(readOnly = true)
	public List<TutorListViewDto> findAllByPageAndSize(Pageable pageable, TutorListDto tutorListDto) {
		TutorPersonalInfo persnlInfo = null;
		TutorProfileInfo proInfo = null;
		try {
			Page<TutorProfile> tp = tutorProfileRepo.findAll(pageable);
			tutorListDto.setTotalCount(tp.getTotalElements());
			tutorListDto.setTotalPages(tp.getTotalPages());
			List<TutorListViewDto> tutors = new ArrayList<>();
			for (TutorProfile t : tp) {
				try {

					persnlInfo = t.getTutorPersonalInfo();
					proInfo = t.getTutorProfileInfo();
					TutorPersonalInfoDto persnlInfoDto = objectMapper.convertValue(persnlInfo,
							TutorPersonalInfoDto.class);
					TutorProfileInfoDto proInfoDto = objectMapper.convertValue(proInfo, TutorProfileInfoDto.class);
					TutorListViewDto dto = new TutorListViewDto();
					dto.setUserId(t.getUser().getId());
					if (t != null && persnlInfoDto != null && proInfo != null) {
						/*
						 * Set<UserLanguage> tLang=persnlInfoDto.getLanguageList(); Set<TutorSubject>
						 * tSubj=proInfo.getTutorSubjects(); Set<TutorEducation>
						 * tEdu=proInfo.getEducations(); Set<TutorCertificate>
						 * tcert=proInfo.getCertificates();
						 */
						dto.setDisplayName(persnlInfoDto.getDisplayName());
						dto.setTutorPersonalInfoId(persnlInfoDto.getTutorPersonalInfoId());
						dto.setPreferredChat(persnlInfoDto.getPreferredChat());
						dto.setSkypeId(persnlInfoDto.getSkypeId());
						dto.setZoomMeetingLink(persnlInfoDto.getZoomMeetingLink());
						dto.setZoomMeetingId(persnlInfoDto.getZoomMeetingId());
						dto.setZoomPassCode(persnlInfoDto.getZoomPassCode());
						dto.setFromCountry(persnlInfoDto.getFromCountry());
						dto.setFromState(persnlInfoDto.getFromState());
						dto.setFromCity(persnlInfoDto.getFromCity());
						dto.setLivingInCountry(persnlInfoDto.getLivingInCountry());
						dto.setLivingInState(persnlInfoDto.getLivingInState());
						dto.setLivingInCity(persnlInfoDto.getLivingInCity());
						dto.setGender(persnlInfoDto.getGender());
						dto.setLanguageList(persnlInfoDto.getLanguageList());
						dto.setProfilePicByte(
								t.getProfileImage() != null ? t.getProfileImage().getImage() : new byte[5]);
						dto.setTutorProfileInfoId(proInfoDto.getTutorProfileInfoId());
						dto.setTutorSubjects(proInfoDto.getTutorSubjects());
						dto.setAboutMe(proInfoDto.getAboutMe());
						dto.setAboutTeachingExp(proInfoDto.getAboutTeachingExp());
						dto.setOtherInfo(proInfoDto.getOtherInfo());
						dto.setHourlyRate(proInfoDto.getHourlyRate());
						dto.setCurrency(proInfoDto.getCurrency());
						dto.setEducations(proInfoDto.getEducations());
						dto.setCertificates(proInfoDto.getCertificates());
						dto.setCreatedDate(t.getCreatedDate());
					}
					tutors.add(dto);
				} catch (Exception e) {
					logger.error("Error for tutor profile id" + persnlInfo.getTutorPersonalInfoId(), e);
				}
			}
			return tutors;

		} catch (Exception e) {
			logger.error("Error occurred while fetching tutors.", e);
			throw new ApplicationException("Error occurred while fetching tutors.");
		}
	}

	@Transactional(readOnly = true)
	public TutorListViewDto findByTutorId(TutorListViewDto dto) {
		TutorProfile tp=null;
		TutorPersonalInfo persnlInfo = null;
		TutorProfileInfo proInfo = null;
		try {
			User user = userService.findByUserIdAndType(dto.getUserId()
					, AppConstants.USER_TYPE_TUTOR);
			if(user==null)
			{
				throw new ResourceNotFoundException("Tutor Not found");
			}
			tp=user.getTutorProfile();
			persnlInfo = tp.getTutorPersonalInfo();
			proInfo = tp.getTutorProfileInfo();
			TutorPersonalInfoDto persnlInfoDto = objectMapper.convertValue(persnlInfo,
					TutorPersonalInfoDto.class);
			TutorProfileInfoDto proInfoDto = objectMapper.convertValue(proInfo, TutorProfileInfoDto.class);
			if (tp != null && persnlInfoDto != null && proInfo != null) {
				dto.setDisplayName(persnlInfoDto.getDisplayName());
				dto.setTutorPersonalInfoId(persnlInfoDto.getTutorPersonalInfoId());
				dto.setPreferredChat(persnlInfoDto.getPreferredChat());
				dto.setSkypeId(persnlInfoDto.getSkypeId());
				dto.setZoomMeetingLink(persnlInfoDto.getZoomMeetingLink());
				dto.setZoomMeetingId(persnlInfoDto.getZoomMeetingId());
				dto.setZoomPassCode(persnlInfoDto.getZoomPassCode());
				dto.setFromCountry(persnlInfoDto.getFromCountry());
				dto.setFromState(persnlInfoDto.getFromState());
				dto.setFromCity(persnlInfoDto.getFromCity());
				dto.setLivingInCountry(persnlInfoDto.getLivingInCountry());
				dto.setLivingInState(persnlInfoDto.getLivingInState());
				dto.setLivingInCity(persnlInfoDto.getLivingInCity());
				dto.setGender(persnlInfoDto.getGender());
				dto.setLanguageList(persnlInfoDto.getLanguageList());
				dto.setProfilePicByte(
						tp.getProfileImage() != null ? tp.getProfileImage().getImage() : new byte[5]);
				dto.setTutorProfileInfoId(proInfoDto.getTutorProfileInfoId());
				dto.setTutorSubjects(proInfoDto.getTutorSubjects());
				dto.setAboutMe(proInfoDto.getAboutMe());
				dto.setAboutTeachingExp(proInfoDto.getAboutTeachingExp());
				dto.setOtherInfo(proInfoDto.getOtherInfo());
				dto.setHourlyRate(proInfoDto.getHourlyRate());
				dto.setCurrency(proInfoDto.getCurrency());
				dto.setEducations(proInfoDto.getEducations());
				dto.setExperiences(proInfoDto.getExperiences());
				dto.setCertificates(proInfoDto.getCertificates());
				dto.setCreatedDate(tp.getCreatedDate());
			}
			return dto;
		}
			catch (Exception e) {
					logger.error("Error for tutor profile id" + dto.getUserId(), e);
					throw new ApplicationException("Error for user id"+dto.getUserId());
			}
			
		}

}

package com.tutor.api.dto;

import java.util.Set;

public class TutorProfileInfoDto {
	
	private long tutorProfileInfoId;
	
	private Set<TutorSubjectDto> tutorSubjects;
	
	private String aboutMe;
	private String aboutTeachingExp;
	private String otherInfo;
	private int hourlyRate;
	
	private String currency;
	
	private Set<TutorEducationDto> educations;
	
	private Set<TutorExperienceDto> experiences;
	
	private Set<TutorCertificateDto> certificates;

	public long getTutorProfileInfoId() {
		return tutorProfileInfoId;
	}

	public void setTutorProfileInfoId(long tutorProfileInfoId) {
		this.tutorProfileInfoId = tutorProfileInfoId;
	}

	public Set<TutorSubjectDto> getTutorSubjects() {
		return tutorSubjects;
	}

	public void setTutorSubjects(Set<TutorSubjectDto> tutorSubjects) {
		this.tutorSubjects = tutorSubjects;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getAboutTeachingExp() {
		return aboutTeachingExp;
	}

	public void setAboutTeachingExp(String aboutTeachingExp) {
		this.aboutTeachingExp = aboutTeachingExp;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Set<TutorEducationDto> getEducations() {
		return educations;
	}

	public void setEducations(Set<TutorEducationDto> educations) {
		this.educations = educations;
	}

	public Set<TutorExperienceDto> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<TutorExperienceDto> experiences) {
		this.experiences = experiences;
	}

	public Set<TutorCertificateDto> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<TutorCertificateDto> certificates) {
		this.certificates = certificates;
	}
	
	
}

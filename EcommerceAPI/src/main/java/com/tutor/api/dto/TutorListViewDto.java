package com.tutor.api.dto;

import java.util.Set;

public class TutorListViewDto {

	private long userId;
	private long tutorProfileMastId;
	private String displayName;
	private long tutorPersonalInfoId;
	private String preferredChat;
	private String skypeId;
	private String zoomMeetingLink;
	private String zoomMeetingId;
	private String zoomPassCode;
	private String fromCountry;
	private String fromState;
	private String fromCity;
	private String livingInCountry;
	private String livingInState;
	private String livingInCity;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String gender;
	private String currentAddress;
	private String permAddress;
	private String defLangaugeName;
	private String defLangLevel;
	private Set<UserLanguageDto> languageList;
	private byte[] profilePicByte;
	private long tutorProfileInfoId;
	private Set<TutorSubjectDto> tutorSubjects;
	private String aboutMe;
	private String aboutTeachingExp;
	private String otherInfo;
	private long hourlyRate;
	private String currency;
	private Set<TutorEducationDto> educations;
	private Set<TutorExperienceDto> experiences;
	private Set<TutorCertificateDto> certificates;
	private long createdDate;
	
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTutorProfileMastId() {
		return tutorProfileMastId;
	}
	public void setTutorProfileMastId(long tutorProfileMastId) {
		this.tutorProfileMastId = tutorProfileMastId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public long getTutorPersonalInfoId() {
		return tutorPersonalInfoId;
	}
	public void setTutorPersonalInfoId(long tutorPersonalInfoId) {
		this.tutorPersonalInfoId = tutorPersonalInfoId;
	}
	public String getPreferredChat() {
		return preferredChat;
	}
	public void setPreferredChat(String preferredChat) {
		this.preferredChat = preferredChat;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public String getZoomMeetingLink() {
		return zoomMeetingLink;
	}
	public void setZoomMeetingLink(String zoomMeetingLink) {
		this.zoomMeetingLink = zoomMeetingLink;
	}
	public String getZoomMeetingId() {
		return zoomMeetingId;
	}
	public void setZoomMeetingId(String zoomMeetingId) {
		this.zoomMeetingId = zoomMeetingId;
	}
	public String getZoomPassCode() {
		return zoomPassCode;
	}
	public void setZoomPassCode(String zoomPassCode) {
		this.zoomPassCode = zoomPassCode;
	}
	public String getFromCountry() {
		return fromCountry;
	}
	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}
	public String getFromState() {
		return fromState;
	}
	public void setFromState(String fromState) {
		this.fromState = fromState;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getLivingInCountry() {
		return livingInCountry;
	}
	public void setLivingInCountry(String livingInCountry) {
		this.livingInCountry = livingInCountry;
	}
	public String getLivingInState() {
		return livingInState;
	}
	public void setLivingInState(String livingInState) {
		this.livingInState = livingInState;
	}
	public String getLivingInCity() {
		return livingInCity;
	}
	public void setLivingInCity(String livingInCity) {
		this.livingInCity = livingInCity;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getPermAddress() {
		return permAddress;
	}
	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}
	public String getDefLangaugeName() {
		return defLangaugeName;
	}
	public void setDefLangaugeName(String defLangaugeName) {
		this.defLangaugeName = defLangaugeName;
	}
	public String getDefLangLevel() {
		return defLangLevel;
	}
	public void setDefLangLevel(String defLangLevel) {
		this.defLangLevel = defLangLevel;
	}
	public Set<UserLanguageDto> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(Set<UserLanguageDto> languageList) {
		this.languageList = languageList;
	}
	public byte[] getProfilePicByte() {
		return profilePicByte;
	}
	public void setProfilePicByte(byte[] profilePicByte) {
		this.profilePicByte = profilePicByte;
	}
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
	public long getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(long hourlyRate) {
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
	public long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}
	
	
}

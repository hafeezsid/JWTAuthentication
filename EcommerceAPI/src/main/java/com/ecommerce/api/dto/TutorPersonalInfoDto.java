package com.ecommerce.api.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TutorPersonalInfoDto {

	private long tutorPersonalInfoId;
	
	private String displayName;
	
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
	
	private byte[] profilePicByte;
	
	private Set<UserLanguageDto> languageList; 

	public long getTutorPersonalInfoId() {
		return tutorPersonalInfoId;
	}

	public void setTutorPersonalInfoId(long tutorPersonalInfoId) {
		this.tutorPersonalInfoId = tutorPersonalInfoId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	
	
	
	
}

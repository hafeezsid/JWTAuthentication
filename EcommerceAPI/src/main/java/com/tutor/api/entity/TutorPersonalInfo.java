package com.tutor.api.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class TutorPersonalInfo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2879029461800942007L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_personal_info_id")
	private long tutorPersonalInfoId;
	@Column
	private String displayName;
	@Column
	private String preferredChat;
	@Column
	private String skypeId;
	@Column
	private String zoomMeetingLink;
	@Column
	private String zoomMeetingId;
	@Column
	private String zoomPassCode;
	@Column
	private String fromCountry;
	@Column
	private String fromState;
	@Column
	private String fromCity;
	@Column
	private String livingInCountry;
	@Column
	private String livingInState;
	@Column
	private String livingInCity;
	@Column
	private String birthYear;
	@Column
	private String birthMonth;
	@Column
	private String birthDay;
	@Column
	private String gender;
	@Column
	private String currentAddress;
	@Column
	private String permAddress;
	@Column
	private String defLangaugeName;
	
	@Column
	private String defLangLevel;
	
	@Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;
    
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
	
	@OneToOne
	@JoinColumn(name = "tutor_profile_mast_id",referencedColumnName = "tutor_profile_mast_id")
	@JsonIgnore
	private TutorProfile tutorProfile;
	
	@OneToMany(mappedBy = "tutorPersonalInfo", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<UserLanguage> languageList;
	
	
	public TutorPersonalInfo() {
	}


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


	
	

	public TutorProfile getTutorProfile() {
		return tutorProfile;
	}


	public void setTutorProfile(TutorProfile tutorProfile) {
		this.tutorProfile = tutorProfile;
	}


	public Set<UserLanguage> getLanguageList() {
		return languageList;
	}


	public void setLanguageList(Set<UserLanguage> languageList) {
		this.languageList = languageList;
	}


	public String getDefLangLevel() {
		return defLangLevel;
	}


	public void setDefLangLevel(String defLangLevel) {
		this.defLangLevel = defLangLevel;
	}


	public long getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}


	public long getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}

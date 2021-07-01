package com.ecommerce.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserLanguage implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5241124256854446211L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_language_id")
	private long userLanguageId;
	@Column
	private String languageName;
	@Column
	private String level;
	@Column
	private boolean isDefault;
	
	@ManyToOne
	@JoinColumn(name="tutor_personal_info_id", referencedColumnName = "tutor_personal_info_id")
	private TutorPersonalInfo tutorPersonalInfo;
	
	public UserLanguage() {
	}

	public long getUserLanguageId() {
		return userLanguageId;
	}

	public void setUserLanguageId(long userLanguageId) {
		this.userLanguageId = userLanguageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public TutorPersonalInfo getTutorPersonalInfo() {
		return tutorPersonalInfo;
	}

	public void setTutorPersonalInfo(TutorPersonalInfo tutorPersonalInfo) {
		this.tutorPersonalInfo = tutorPersonalInfo;
	}

	
	
	
	
}

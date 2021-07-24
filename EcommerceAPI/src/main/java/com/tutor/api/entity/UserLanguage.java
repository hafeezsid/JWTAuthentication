package com.tutor.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
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
	private String languageCode;
	@Column
	private String levelCode;
	@Column
	private boolean isDefault;
	
	@ManyToOne
	@JoinColumn(name="tutor_personal_info_id", referencedColumnName = "tutor_personal_info_id")
	@JsonIgnore
	private TutorPersonalInfo tutorPersonalInfo;
	
	
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
	
	public UserLanguage() {
	}

	public long getUserLanguageId() {
		return userLanguageId;
	}

	public void setUserLanguageId(long userLanguageId) {
		this.userLanguageId = userLanguageId;
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

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
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

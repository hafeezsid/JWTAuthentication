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

@Entity(name = "tutor_subject")
@EntityListeners(AuditingEntityListener.class)
public class TutorSubject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7761116830971385666L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_subject_id")
	private long tutorSubjectId;
	
	@Column(name="subject_code")
	private String subjectCode;
	@Column(name = "level_code")
	private String levelCode;
	
	@Column (columnDefinition = "boolean default false")
	private Boolean isDefault;
	
	@ManyToOne
	@JoinColumn(name="tutor_profile_info_id", referencedColumnName = "tutor_profile_info_id")
	@JsonIgnore
	private TutorProfileInfo tutorProfileInfo;

	
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
    
	public long getTutorSubjectId() {
		return tutorSubjectId;
	}

	public void setTutorSubjectId(long tutorSubjectId) {
		this.tutorSubjectId = tutorSubjectId;
	}

	
	
	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public TutorProfileInfo getTutorProfileInfo() {
		return tutorProfileInfo;
	}

	public void setTutorProfileInfo(TutorProfileInfo tutorProfileInfo) {
		this.tutorProfileInfo = tutorProfileInfo;
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

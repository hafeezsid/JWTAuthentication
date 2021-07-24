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
public class TutorEducation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4496820189427807540L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_education_id")
	private long tutorEducationId;
	
	@Column
	private int fromYear;
	@Column
    private int toYear;
	@Column
    private String institutionName;
	@Column
	private String major;
	@Column
	private String degree;
	@Column
	private String additionInfo;
	
	@Column
	private String documentType;
	
	@Column
	private String documentName;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean uploadStatus;
	
	@Column
    private byte [] attachedDoc;
	
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
	
	public long getTutorEducationId() {
		return tutorEducationId;
	}
	public void setTutorEducationId(long tutorEducationId) {
		this.tutorEducationId = tutorEducationId;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getAdditionInfo() {
		return additionInfo;
	}
	public void setAdditionInfo(String additionInfo) {
		this.additionInfo = additionInfo;
	}
	public byte[] getAttachedDoc() {
		return attachedDoc;
	}
	public void setAttachedDoc(byte[] attachedDoc) {
		this.attachedDoc = attachedDoc;
	}
	public int getFromYear() {
		return fromYear;
	}
	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}
	public int getToYear() {
		return toYear;
	}
	public void setToYear(int toYear) {
		this.toYear = toYear;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public TutorProfileInfo getTutorProfileInfo() {
		return tutorProfileInfo;
	}
	public void setTutorProfileInfo(TutorProfileInfo tutorProfileInfo) {
		this.tutorProfileInfo = tutorProfileInfo;
	}
	public Boolean isUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(Boolean uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public Boolean getUploadStatus() {
		return uploadStatus;
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

package com.ecommerce.api.entity;

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
public class TutorCertificate implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7466924189752822817L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_certificate_id")
	private long tutorCertificateId;
	
	@Column
	private int acquiredYear;

	@Column
    private String certificateName;
	@Column
	private String provider;
	@Column
	private String certificateLink;

	private String documentType;
	@Column(columnDefinition = "boolean default false")
	private Boolean uploadStatus;
	
	@Column
	private String documentName;
	
	
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
	
	public long getTutorCertificateId() {
		return tutorCertificateId;
	}
	public void setTutorCertificateId(long tutorCertificateId) {
		this.tutorCertificateId = tutorCertificateId;
	}
	public int getAcquiredYear() {
		return acquiredYear;
	}
	public void setAcquiredYear(int acquiredYear) {
		this.acquiredYear = acquiredYear;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getCertificateLink() {
		return certificateLink;
	}
	public void setCertificateLink(String certificateLink) {
		this.certificateLink = certificateLink;
	}
	public byte[] getAttachedDoc() {
		return attachedDoc;
	}
	public void setAttachedDoc(byte[] attachedDoc) {
		this.attachedDoc = attachedDoc;
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

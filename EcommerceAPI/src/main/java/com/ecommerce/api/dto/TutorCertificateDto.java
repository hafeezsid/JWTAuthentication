package com.ecommerce.api.dto;

public class TutorCertificateDto {
	private long tutorCertificateId;
	private int acquiredYear;
	private String certificateName;
	private String provider;
	private String certificateLink;
	private String documentType;
	private Boolean uploadStatus;
	private byte[] attachedDoc;

	private String documentName;
	
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
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public Boolean getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(Boolean uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	public byte[] getAttachedDoc() {
		return attachedDoc;
	}
	public void setAttachedDoc(byte[] attachedDoc) {
		this.attachedDoc = attachedDoc;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	
}

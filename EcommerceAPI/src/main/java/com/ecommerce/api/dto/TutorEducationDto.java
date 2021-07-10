package com.ecommerce.api.dto;

public class TutorEducationDto {
	
	private long tutorEducationId;
	private int fromYear;
	private int toYear;
	private String institutionName;
	private String major;
	private String degree;
	private String additionInfo;
	private String documentType;
	private boolean uploadStatus;
	private byte[] attachedDoc;
	private String documentName;
	
	public long getTutorEducationId() {
		return tutorEducationId;
	}
	public void setTutorEducationId(long tutorEducationId) {
		this.tutorEducationId = tutorEducationId;
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
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public boolean isUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(boolean uploadStatus) {
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

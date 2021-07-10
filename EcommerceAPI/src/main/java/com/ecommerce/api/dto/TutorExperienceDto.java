package com.ecommerce.api.dto;

public class TutorExperienceDto {
	
	private long tutorExperienceId;
	private int fromYear;
	private int toYear;
	private String company;
	private String designation;
	private String country;
	private String state;
	private String city;
	private String additionInfo;
	private String documentType;
	private Boolean uploadStatus;
	private byte[] attachedDoc;
	public long getTutorExperienceId() {
		return tutorExperienceId;
	}
	public void setTutorExperienceId(long tutorExperienceId) {
		this.tutorExperienceId = tutorExperienceId;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public Boolean isUploadStatus() {
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
	
	
}

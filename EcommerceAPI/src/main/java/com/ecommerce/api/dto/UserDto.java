package com.ecommerce.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String username;
	private String contactNumber;
	//private TutorProfile tutorProfile;
	//private String profileImgUrl;
	//private boolean isActive;
	private String userType;
	private Boolean isProfileApproved;
	private Boolean isRegFirstStepComplete;
	private Boolean isRegSecondStepComplete;
	private Boolean isRegFinalStepComplete;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Boolean getIsProfileApproved() {
		return isProfileApproved;
	}
	public void setIsProfileApproved(Boolean isProfileApproved) {
		this.isProfileApproved = isProfileApproved;
	}
	public Boolean getIsRegFirstStepComplete() {
		return isRegFirstStepComplete;
	}
	public void setIsRegFirstStepComplete(Boolean isRegFirstStepComplete) {
		this.isRegFirstStepComplete = isRegFirstStepComplete;
	}
	public Boolean getIsRegSecondStepComplete() {
		return isRegSecondStepComplete;
	}
	public void setIsRegSecondStepComplete(Boolean isRegSecondStepComplete) {
		this.isRegSecondStepComplete = isRegSecondStepComplete;
	}
	public Boolean getIsRegFinalStepComplete() {
		return isRegFinalStepComplete;
	}
	public void setIsRegFinalStepComplete(Boolean isRegFinalStepComplete) {
		this.isRegFinalStepComplete = isRegFinalStepComplete;
	}
	
	
	
}

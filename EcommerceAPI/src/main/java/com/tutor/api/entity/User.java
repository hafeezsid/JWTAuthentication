package com.tutor.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2346737130325253712L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "mid_name")
	private String middleName;
	@Column(name = "email")
	private String email;
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "join_date")
	private Date joinDate;
	@Column(name = "is_not_locked")
	private boolean isNotLocked;
	
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private TutorProfile tutorProfile;
	
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "stuudent_profile_id",referencedColumnName =
	 * "student_profile_id") private StudentProfile studentProfile;
	 */
	private String profileImgUrl;
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column
	private String userType;
	
	@Column (columnDefinition = "boolean default false")
	private Boolean isProfileApproved;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean isRegFirstStepComplete;
	
	@Column (columnDefinition = "boolean default false")
	private Boolean isRegSecondStepComplete;
	
	@Column(columnDefinition = "boolean default false") 
	private Boolean isRegFinalStepComplete;
	
	
	private String[] roles; // ROLE_USER, ROLE_ADMIN
	private String[] authorities; // delete, update, read, insert
	
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
	
	public User() {
	}
	
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public User(String firstName, String lastName, String email, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = userName;
		this.password = password;
	}
	
	public User(long id, String firstName, String lastName, String email, String username, String password,
			Date joinDate, boolean isNotLocked, String profileImgUrl, boolean isActive, String[] roles,
			String[] authorities) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.joinDate = joinDate;
		this.isNotLocked = isNotLocked;
		this.profileImgUrl = profileImgUrl;
		this.isActive = isActive;
		this.roles = roles;
		this.authorities = authorities;
	}
	
	

	public User(String firstName, String lastName, String email, String username, String password, Date joinDate,
			boolean isNotLocked, String profileImgUrl, boolean isActive) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.joinDate = joinDate;
		this.isNotLocked = isNotLocked;
		this.profileImgUrl = profileImgUrl;
		this.isActive = isActive;
	}

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	

	public String getProfileImgUrl() {
		return profileImgUrl;
	}

	public void setProfileImgUrl(String profileImgUrl) {
		this.profileImgUrl = profileImgUrl;
	}

	public boolean isNotLocked() {
		return isNotLocked;
	}

	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String[] getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String[] authorities) {
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public TutorProfile getTutorProfile() {
		return tutorProfile;
	}

	public void setTutorProfile(TutorProfile tutorProfile) {
		this.tutorProfile = tutorProfile;
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

package com.tutor.api.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "tutor_profile_mast")
@EntityListeners(AuditingEntityListener.class)
public class TutorProfile implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6301374254499919984L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_profile_mast_id")
	private long tutorProfileMastId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private User user;

	@OneToOne(mappedBy = "tutorProfile",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private TutorPersonalInfo tutorPersonalInfo;
	
	@OneToOne(mappedBy = "tutorProfile",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private TutorProfileInfo tutorProfileInfo;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_image_id",referencedColumnName = "image_id")
	private ProfileImage profileImage;
	
	@Column 
	private Boolean isProfileComplete;
	
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
	
	public long getTutorProfileMastId() {
		return tutorProfileMastId;
	}

	public void setTutorProfileMastId(long tutorProfileMastId) {
		this.tutorProfileMastId = tutorProfileMastId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TutorPersonalInfo getTutorPersonalInfo() {
		return tutorPersonalInfo;
	}

	public void setTutorPersonalInfo(TutorPersonalInfo tutorPersonalInfo) {
		this.tutorPersonalInfo = tutorPersonalInfo;
	}

	public TutorProfileInfo getTutorProfileInfo() {
		return tutorProfileInfo;
	}

	public void setTutorProfileInfo(TutorProfileInfo tutorProfileInfo) {
		this.tutorProfileInfo = tutorProfileInfo;
	}

	public Boolean getIsProfileComplete() {
		return isProfileComplete;
	}

	public void setIsProfileComplete(Boolean isProfileComplete) {
		this.isProfileComplete = isProfileComplete;
	}

	public ProfileImage getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(ProfileImage profileImage) {
		this.profileImage = profileImage;
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

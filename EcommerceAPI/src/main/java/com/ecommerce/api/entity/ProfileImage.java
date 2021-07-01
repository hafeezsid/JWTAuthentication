package com.ecommerce.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProfileImage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3418273284517343714L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Long profileImageId;
	
	@Lob
	private byte[] image;

	
	public ProfileImage() {
		// TODO Auto-generated constructor stub
	}
	public Long getProfileImageId() {
		return profileImageId;
	}

	public void setProfileImageId(Long profileImageId) {
		this.profileImageId = profileImageId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}

package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2346737130325253712L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "join_date")
	private String joinDate;
	@Column(name = "is_not_locked")
	private boolean isNotLocked;
	@Column(name = "profile_img_url")
	private String profileImgUrl;
	@Column(name = "is_active")
	private boolean isActive;
	
	private String[] roles; // ROLE_USER, ROLE_ADMIN
	private String[] authorities; // delete, update, read, insert
	
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
			String joinDate, boolean isNotLocked, String profileImgUrl, boolean isActive, String[] roles,
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
	
	

	public User(String firstName, String lastName, String email, String username, String password, String joinDate,
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

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
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
	
	
	
	
}

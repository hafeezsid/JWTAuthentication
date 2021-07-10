package com.ecommerce.api.model;

import com.ecommerce.api.dto.UserDto;

public class AuthResp {
	private UserDto user;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	

}

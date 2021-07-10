package com.ecommerce.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLanguageDto {

	private long userLanguageId;
	private String languageCode;
	private String levelCode;
	@JsonProperty
	private boolean isDefault;

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public long getUserLanguageId() {
		return userLanguageId;
	}

	public void setUserLanguageId(long userLanguageId) {
		this.userLanguageId = userLanguageId;
	}

}

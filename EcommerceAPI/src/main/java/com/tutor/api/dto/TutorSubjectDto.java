package com.tutor.api.dto;

public class TutorSubjectDto {

	private long tutorSubjectId;
	
	private String subjectCode;
	private String levelCode;
	
	private Boolean isDefault;

	public long getTutorSubjectId() {
		return tutorSubjectId;
	}

	public void setTutorSubjectId(long tutorSubjectId) {
		this.tutorSubjectId = tutorSubjectId;
	}

	

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	
}

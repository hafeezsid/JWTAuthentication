package com.example.demo.exceptionHandler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse {

	private String message;
	private String errorCode;
	private LocalDateTime exceptionTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public LocalDateTime getExceptionTime() {
		return exceptionTime;
	}
	public void setExceptionTime(LocalDateTime exceptionTime) {
		this.exceptionTime = exceptionTime;
	}
	
}

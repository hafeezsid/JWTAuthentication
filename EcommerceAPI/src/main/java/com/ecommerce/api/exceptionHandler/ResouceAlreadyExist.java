package com.ecommerce.api.exceptionHandler;

public class ResouceAlreadyExist extends RuntimeException {
	public ResouceAlreadyExist(String message) {
	super(message);
	}
}

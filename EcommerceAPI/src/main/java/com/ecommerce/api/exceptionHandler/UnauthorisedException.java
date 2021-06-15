package com.ecommerce.api.exceptionHandler;

public class UnauthorisedException extends RuntimeException{
	
	public UnauthorisedException(String message) {
		super(message);
	}

}

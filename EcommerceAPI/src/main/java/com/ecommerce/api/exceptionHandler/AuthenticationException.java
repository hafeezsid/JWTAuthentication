package com.ecommerce.api.exceptionHandler;

public class AuthenticationException extends RuntimeException {
	public AuthenticationException(String message)
	{
		super(message);
	}
}

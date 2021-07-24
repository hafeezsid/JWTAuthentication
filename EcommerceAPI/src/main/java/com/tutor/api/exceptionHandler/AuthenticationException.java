package com.tutor.api.exceptionHandler;

public class AuthenticationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7884202796392517792L;

	public AuthenticationException(String message)
	{
		super(message);
	}
}

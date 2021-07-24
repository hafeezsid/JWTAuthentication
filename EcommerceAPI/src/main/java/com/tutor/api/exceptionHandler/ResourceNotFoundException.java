package com.tutor.api.exceptionHandler;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7043416729316678578L;

	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}

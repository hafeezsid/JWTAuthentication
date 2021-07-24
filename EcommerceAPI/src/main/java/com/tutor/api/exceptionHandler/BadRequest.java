package com.tutor.api.exceptionHandler;

public class BadRequest extends RuntimeException{
/**
	 * 
	 */
	private static final long serialVersionUID = -6607150902490568159L;

public BadRequest(String message)
{
	super(message);
}
}

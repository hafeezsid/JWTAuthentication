package com.tutor.api.exceptionHandler;

public class ResourceAlreadyExist extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2524190974135294579L;

	public ResourceAlreadyExist(String message) {
	super(message);
	}
}

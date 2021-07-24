package com.tutor.api.exceptionHandler;

public class UnauthorisedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7658567082272317916L;

	public UnauthorisedException(String message) {
		super(message);
	}

}

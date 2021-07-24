package com.tutor.api.exceptionHandler;

public class ApplicationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1403665681525125922L;

	public ApplicationException(String message){
		super(message);
	}
	
	public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
	
}

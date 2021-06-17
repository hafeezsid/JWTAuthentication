package com.ecommerce.api.exceptionHandler;

public class ServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4854629300588771449L;

	ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

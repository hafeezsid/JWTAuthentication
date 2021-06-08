package com.example.demo.exceptionHandler;

public class UnauthorisedException extends RuntimeException{
	
	public UnauthorisedException(String message) {
		super(message);
	}

}

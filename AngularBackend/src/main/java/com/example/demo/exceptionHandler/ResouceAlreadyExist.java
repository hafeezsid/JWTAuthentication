package com.example.demo.exceptionHandler;

public class ResouceAlreadyExist extends RuntimeException {
	public ResouceAlreadyExist(String message) {
	super(message);
	}
}

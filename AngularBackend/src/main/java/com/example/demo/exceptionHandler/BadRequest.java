package com.example.demo.exceptionHandler;

public class BadRequest extends RuntimeException{
public BadRequest(String message)
{
	super(message);
}
}

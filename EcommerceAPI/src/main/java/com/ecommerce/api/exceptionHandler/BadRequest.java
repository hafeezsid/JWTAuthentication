package com.ecommerce.api.exceptionHandler;

public class BadRequest extends RuntimeException{
public BadRequest(String message)
{
	super(message);
}
}

package com.tutor.api.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tutor.api.model.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UnauthorisedException.class)
	public ResponseEntity<ExceptionResponse> unauthorisedException(UnauthorisedException ex)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setErrorCode("Unauthorised");
		response.setExceptionTime(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ExceptionResponse> authenticationException(AuthenticationException ex)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setErrorCode("Authentication Error");
		response.setExceptionTime(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(ResourceAlreadyExist.class)
	public ResponseEntity<ExceptionResponse> resourceAlreadyExist(ResourceAlreadyExist ex)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setErrorCode("Conflict");
		response.setExceptionTime(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFoundException(ResourceNotFoundException ex)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setErrorCode("Not found");
		response.setExceptionTime(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionResponse> customException(CustomException ex)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setErrorCode("Internal Server Error");
		response.setExceptionTime(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ExceptionResponse> applicationException(ApplicationException ex)
	{
		ExceptionResponse response=new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setErrorCode("Internal Server Error");
		response.setExceptionTime(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

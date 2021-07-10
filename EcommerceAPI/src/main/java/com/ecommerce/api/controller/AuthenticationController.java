package com.ecommerce.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.dto.UserDto;
import com.ecommerce.api.entity.User;
import com.ecommerce.api.exceptionHandler.CustomException;
import com.ecommerce.api.exceptionHandler.ResourceNotFoundException;
import com.ecommerce.api.exceptionHandler.UnauthorisedException;
import com.ecommerce.api.model.AuthRequest;
import com.ecommerce.api.model.AuthResp;
import com.ecommerce.api.repository.UserRepository;
import com.ecommerce.api.service.UserService;
import com.ecommerce.api.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	Logger logger=LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	JwtUtil JwtUtil;
	
	@PostMapping
	public ResponseEntity<AuthResp> authenticate(@RequestBody AuthRequest request)
	{
		Authentication auth=null;
		AuthResp ar=null;
		try {
		auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		if(auth==null)
		{
			logger.warn("Incorrect username/email or password");
			throw new ResourceNotFoundException("Incorrect username/email or password");
		}
		String jwtToken=JwtUtil.generateToken(request.getUsername());
		ar=new AuthResp();
		UserDto userDto = new UserDto();
		User user=userRepo.findByUsername(request.getUsername());
		userDto.setUsername(user.getUsername());
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setMiddleName(user.getMiddleName());
		userDto.setLastName(user.getLastName());
		userDto.setUserType(user.getUserType());
		userDto.setIsProfileApproved(user.getIsProfileApproved());
		userDto.setIsRegSecondStepComplete(user.getIsRegSecondStepComplete());
		userDto.setIsRegFirstStepComplete(user.getIsRegFirstStepComplete());
		userDto.setIsRegFinalStepComplete(user.getIsRegFinalStepComplete());
		userDto.setIsRegFinalStepComplete(user.getIsRegFinalStepComplete());
		ar.setToken(jwtToken);
		ar.setUser(userDto);
		}
		catch(AuthenticationException ex)
		{
			logger.error(ex.getMessage(),ex);
			throw new UnauthorisedException(ex.getMessage());
		}
		catch (Exception ex) {
			if(auth==null)
			{
				throw new ResourceNotFoundException("Incorrect username/email or password");
			}
			logger.error(ex.getMessage(),ex);
			throw new CustomException(ex.getMessage());
		}
		return new ResponseEntity<>(ar,HttpStatus.OK);
	}

}

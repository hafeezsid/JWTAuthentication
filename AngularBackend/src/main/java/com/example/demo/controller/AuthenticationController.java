package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionHandler.UnauthorisedException;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.AuthResp;
import com.example.demo.utils.JwtUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil JwtUtil;
	
	@PostMapping
	public ResponseEntity<AuthResp> authenticate(@RequestBody AuthRequest request) throws UnauthorisedException
	{
		try {
		System.out.println(request.getUsername());
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		
		}
		catch(org.springframework.security.core.AuthenticationException ex)
		{
			throw new UnauthorisedException(ex.getMessage());
		}
		
		String jwtToken=JwtUtil.generateToken(request.getUsername());
		AuthResp ar=new AuthResp();
		ar.setUsername(request.getUsername());
		ar.setToken(jwtToken);
		return new ResponseEntity<AuthResp>(ar,HttpStatus.OK);
	}

}

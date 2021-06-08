package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthRequest;
import com.example.demo.utils.JwtUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil JwtUtil;
	
	@PostMapping
	public String authenticate(@RequestBody AuthRequest request) throws Exception
	{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}
		catch(Exception ex)
		{
			throw new Exception("Invalid credentials");
		}
		
		return JwtUtil.generateToken(request.getUsername());
	}

}

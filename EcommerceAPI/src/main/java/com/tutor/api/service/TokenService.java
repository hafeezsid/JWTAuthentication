package com.tutor.api.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.api.entity.TokenVerification;
import com.tutor.api.entity.User;
import com.tutor.api.repository.TokenRepository;

@Service
public class TokenService {
	Logger logger=LoggerFactory.getLogger(TokenService.class);
	@Autowired
	TokenRepository tokenRepository;

	public TokenVerification generateNewToken(User user) throws Exception {
		try {
		String token= UUID.randomUUID().toString();
		TokenVerification tokenVerification=new TokenVerification();
		tokenVerification.setUser(user);
		tokenVerification.setToken(token);
		return tokenVerification=tokenRepository.save(tokenVerification);
		}
		catch (Exception e) {
			throw new Exception("Error while generation account activation token ");
		}
		
	}

	public List<TokenVerification> findToken(String activationToken) {
		List<TokenVerification> token = tokenRepository.findByToken(activationToken);
		return token;
	}
}

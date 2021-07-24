package com.tutor.api.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.api.entity.TokenVerification;
import com.tutor.api.entity.User;

@Service
public class RegistrationService {
	Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UserService userService;
	
	public User enableUserAccount(String userid, String activationToken) {
		User user=null;
		try {		
		long id=Long.parseLong(userid);
		if(id!=0 && activationToken!=null && !activationToken.isBlank()) {
			List<TokenVerification> token =tokenService.findToken(activationToken);
			if(token!=null) {
				 user= token.stream().filter(t-> t.getUser().getId()==id).map(u->u.getUser()).findFirst()
						 .orElseThrow(()->new ServiceException("User account is not linked with the token "+activationToken));			
					 user.setActive(true);
					 user=userService.updateUser(user);
					 return user;
				}
			}
		}
		catch (Exception e) {
			throw new ServiceException(e.getMessage(),e);
		}
		return user;
	}
	
}

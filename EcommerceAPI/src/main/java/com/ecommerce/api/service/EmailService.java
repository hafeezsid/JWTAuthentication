package com.ecommerce.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.TokenVerification;
import com.ecommerce.api.entity.User;

@Service
public class EmailService {
	Logger logger = LoggerFactory.getLogger(EmailService.class);
	/*
	 * @Value("${application.api.url") private String apiUrl;
	 */
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendActivationLinkEmail(TokenVerification tv, User user) throws Exception {
		try {
		String apiUrl=env.getProperty("application.api.url");
		String confirmationTokenUrl=apiUrl+"/register/confirmRegistration?id="+user.getId()+"&token="+tv.getToken();
		SimpleMailMessage email = new SimpleMailMessage(); 
		email.setFrom("noreply@organicFarm.com");
		email.setTo(user.getEmail()); 
		email.setSubject("Registration Activation link"); 
		email.setText("Thank you for registring with organic farm.\r\nYou are now one step away to activate your account. Please click on below link to activate your account."+"\r\n"+confirmationTokenUrl+"\r\n\nThis is an automated mail from system. Please donot reply");
        javaMailSender.send(email);
        return true;
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("Error occured while sending activation link email");
		}
	}

}

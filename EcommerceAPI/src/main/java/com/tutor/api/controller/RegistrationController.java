package com.tutor.api.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tutor.api.dto.UserDto;
import com.tutor.api.entity.TokenVerification;
import com.tutor.api.entity.User;
import com.tutor.api.exceptionHandler.BadRequest;
import com.tutor.api.exceptionHandler.CustomException;
import com.tutor.api.exceptionHandler.ResourceAlreadyExist;
import com.tutor.api.service.EmailService;
import com.tutor.api.service.RegistrationService;
import com.tutor.api.service.TokenService;
import com.tutor.api.service.UserService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
	private UserService userService;
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	JavaMailSender mainSender;

	@Autowired
	RegistrationService registrationService;

	@Autowired
	TokenService tokenService;
	@Autowired
	EmailService emailService;

	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
		User savedUser = null;
		logger.info("Starting Registration");
		if (userDto == null) {
			throw new BadRequest("Request doesnot contain enough information");
		}
		try {
			savedUser = userService.findByUsername(userDto.getEmail());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException("Error occurred while registering user.");
		}
		if (savedUser != null) {
			throw new ResourceAlreadyExist("An account for this username/email already exists.");
		}
		try {
			User newUser = new User();
			String[] at = { "ROLE_USER" };
			newUser.setAuthorities(at);
			newUser.setFirstName(userDto.getFirstName());
			newUser.setLastName(userDto.getLastName());
			newUser.setEmail(userDto.getEmail());
			newUser.setContactNumber(userDto.getContactNumber());
			newUser.setJoinDate(new Date());
			newUser.setUsername(userDto.getEmail());
			newUser.setNotLocked(true);
			newUser.setUserType(userDto.getUserType());
			newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
			newUser = userService.saveUser(newUser);
			if (newUser.getId() != 0) {
				TokenVerification tokenVer = tokenService.generateNewToken(newUser);
				if (tokenVer != null && tokenVer.getId() != 0) {
					emailService.sendActivationLinkEmail(tokenVer, newUser);
				}

			}
			logger.info("Registration Successful");
			return new ResponseEntity<>(newUser, HttpStatus.OK);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new CustomException("Error occurred while registering user.");
		}

	}

	@GetMapping("/confirmRegistration")
	public ModelAndView confirmRegistration(@RequestParam Map<String,String> queryParam) {
		String redirectUrl;
		try {
		String userId=queryParam.get("id");
		String activationToken=queryParam.get("token");
		User user = registrationService.enableUserAccount(userId, activationToken);
	
		if (user.isActive()) {
			redirectUrl = "http://localhost:4200/accountConfirmation/success";

		} else {
			redirectUrl = "http://localhost:4200/accountConfirmation/failure";
		}
		return new ModelAndView("redirect:" + redirectUrl);
		}
		catch (Exception e) {
			redirectUrl = "http://localhost:4200/accountConfirmation/failure";
			logger.error(e.getMessage(),e);	
			return new ModelAndView("redirect:" + redirectUrl);
		}

	}

}

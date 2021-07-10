package com.ecommerce.api.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public interface IAuthenticationFacade {
	
	Authentication getAuthentication();
}

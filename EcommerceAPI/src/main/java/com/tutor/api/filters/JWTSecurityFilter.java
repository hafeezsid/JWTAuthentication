package com.tutor.api.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tutor.api.exceptionHandler.AuthenticationException;
import com.tutor.api.service.CustomUserDetailService;
import com.tutor.api.utils.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTSecurityFilter extends OncePerRequestFilter {
	Logger log = LoggerFactory.getLogger(JwtUtil.class);
	@Autowired
	JwtUtil JwtUtil;
	
	@Autowired
	CustomUserDetailService userDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token=null;
		String username=null;
		String authorizationHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
		log.info("authorizationHeader" +authorizationHeader);
		try {
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer"))
		{
			token=authorizationHeader.substring(7);
			username=JwtUtil.extractUsername(token);
		}
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=userDetailService.loadUserByUsername(username);
			log.info("User is identified");
			
			if(JwtUtil.validateToken(token, userDetails)) {
				 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
		}
		}catch (SignatureException e) {
	        log.info("Invalid JWT signature.");
	        log.error("Invalid JWT signature trace: {}", e);
	        throw new AuthenticationException("Invalid JWT signature");
	    } catch (MalformedJwtException e) {
	        log.info("Invalid JWT token.");
	        log.error("Invalid JWT token trace: {}", e);
	        throw new AuthenticationException("Invalid JWT token");
	    } catch (ExpiredJwtException e) {
	        log.info("Your");
	        log.error("Expired JWT token trace: {}", e);
	        throw new AuthenticationException("User session has expired");
	    } catch (UnsupportedJwtException e) {
	        log.info("Unsupported JWT token.");
	        log.error("Unsupported JWT token trace: {}", e);
	        throw new AuthenticationException(e.getMessage());
	    } catch (IllegalArgumentException e) {
	        log.info("JWT token compact of handler are invalid.");
	        log.error("JWT token compact of handler are invalid trace: {}", e);
	        throw new AuthenticationException(e.getMessage());
	    }
		catch (Exception e) {
	        log.info("Authentication Error");
	        log.error(e.getMessage(), e);
	        throw new AuthenticationException(e.getMessage());
	    }
		filterChain.doFilter(request, response);
		
	}

}

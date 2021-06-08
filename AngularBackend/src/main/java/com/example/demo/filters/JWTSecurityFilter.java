package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.CustomUserDetailService;
import com.example.demo.utils.JwtUtil;

@Component
public class JWTSecurityFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil JwtUtil;
	
	@Autowired
	CustomUserDetailService userDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token=null;
		String username=null;
		String authorizationHeader= request.getHeader("Authorization");
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer"))
		{
			token=authorizationHeader.substring(7);
			username=JwtUtil.extractUsername(token);
		}
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=userDetailService.loadUserByUsername(username);
			if(JwtUtil.validateToken(token, userDetails)) {
				 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}

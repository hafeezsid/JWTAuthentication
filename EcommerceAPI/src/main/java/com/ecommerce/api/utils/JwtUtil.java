package com.ecommerce.api.utils;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ecommerce.api.constants.SecurityConstant;
import com.ecommerce.api.entity.User;
import com.ecommerce.api.model.UserPrincipal;
import com.ecommerce.api.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public class JwtUtil {
	Logger log = LoggerFactory.getLogger(JwtUtil.class);
	@Value(value = "${application.security.key}")
	private String secret;

	@Autowired
	UserRepository userRepository;
	@Autowired
	ObjectMapper objectMapper;

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token)
			throws SignatureException, MalformedJwtException, ExpiredJwtException {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(String username) {
		Map<String, Object> claims = getClaimsMapFromUserPrincipal(username);
		return createToken(claims, username);
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String token) {
		Claims claims = extractAllClaims(token);
		Collection<? extends GrantedAuthority> authoritiesList = Stream
				.of(claims.get(SecurityConstant.AUTORITIES).toString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return authoritiesList;
	}

	private Map<String, Object> getClaimsMapFromUserPrincipal(String username) {
		User user = userRepository.findByUsername(username);
		UserPrincipal up = new UserPrincipal(user);
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(SecurityConstant.AUTORITIES, up.getAuthorities());
		return claims;
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

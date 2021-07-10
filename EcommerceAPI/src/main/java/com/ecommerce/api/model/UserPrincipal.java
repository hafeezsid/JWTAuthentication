package com.ecommerce.api.model;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.api.entity.User;


	
public class UserPrincipal implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5281823702977618736L;
	
	private User user;
	
	public UserPrincipal() {
	}
	
	public UserPrincipal(User user)
	{
		this.user=user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Stream.of(this.user.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.user.isNotLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.isActive();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}

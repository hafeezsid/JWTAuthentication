package com.tutor.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tutor.api.filters.ExceptionHandlerFilter;
import com.tutor.api.filters.JWTSecurityFilter;
import com.tutor.api.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	JWTSecurityFilter jwtfilter;
	

	@Autowired
	ExceptionHandlerFilter expfilter;
	
	@Autowired
	private CustomUserDetailService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().cors()
	        .and()
	        .authorizeRequests()
	        .antMatchers("/authenticate").permitAll()
            .antMatchers("/register/**").permitAll()
            .antMatchers("/tutor/fetch/**").permitAll()
            .antMatchers("/user/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
            .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
           
            .anyRequest().authenticated()
            .and().exceptionHandling().and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	        http.addFilterBefore(expfilter, JWTSecurityFilter.class);
	    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean(name= BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	

}

package com.ecommerce.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.repository.ProfileImageRepository;
import com.ecommerce.api.repository.UserRepository;
import com.ecommerce.api.service.ProfileImageService;
import com.ecommerce.api.service.UserService;

@RunWith(SpringRunner.class)
/* @ContextConfiguration(classes = {ProfileImageRepository.class}) */
public class UserServiceTests {

	@MockBean
	UserRepository userRepo;
	@MockBean
	ProfileImageRepository imageRepo;
	
	@Autowired
	UserService userService;
	
	@TestConfiguration
	 static class UserServiceTestsConfiguration{
		@Bean
		public UserService loadUserService()
		{
			return new UserService();
		}
		@Bean
		public ProfileImageService loadProfileImageService()
		{
			return new ProfileImageService();
		}
		
	}
	
	@Before
	public void setup() {
		User user=new User("","","","hafeezsid143@gmail.com","");
		
	}
	
	@Test
	public void givenUserName_whenfindByUsername_thenUser()
	{
		Mockito.when(userRepo.findByUsername("anyString"))
		.thenReturn(new User("","","","hafeezsid143@gmail.com",""));
		User u=userService.findByUsername("anyString");
		assertThat(u.getUsername().equals("hafeezsid143@gmail.com"));
	}
}

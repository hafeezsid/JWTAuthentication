package com.ecommerce.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.repository.UserRepository;
import com.ecommerce.api.service.UserService;
import com.ecommerce.api.utils.JwtUtil;

/*@RunWith(SpringRunner.class)*/
@SpringBootTest
/*
 * @WebMvcTest(controllers = UserController.class, excludeFilters = {
 * 
 * @ComponentScan.Filter(type = FilterType.REGEX,pattern =
 * "com.ecommerce.api.controllers")})
 */
@AutoConfigureMockMvc
public class UserControllerTest {

	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	UserService userService;
	
	
	  @Autowired UserRepository userRepository;
	  
	  
	  @MockBean JwtUtil js;
	 
	
	@Test
	@Ignore
	@WithMockUser(value = "spring")
	public void get_UserDetailsTest() throws Exception
	{
		//Mockito.when(userService.findByUsername("hafeezsid143@gmail.com")).th
		 Mockito.when(userService.findByUsername("hafeezsid143@gmail.com")).thenReturn(new User("","","","hafeezsid143@gmail.com",""));
		 mockMvc.perform(get("/user/{username}","hafeezsid143@gmail.com")
				 .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(jsonPath("$[0].name", is("bob")));
	}
}

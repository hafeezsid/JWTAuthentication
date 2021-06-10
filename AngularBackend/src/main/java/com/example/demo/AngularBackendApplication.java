package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class AngularBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularBackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepo;
	@PostConstruct
	public void init() throws Exception {
		User u1=new User("Mohd","Hafeez","haf@gmail.com","hafeez","hafeez");
		String []a= {"ROLE_USER","ROLE_MANAGER"};
		u1.setAuthorities(a);
		u1.setActive(true);
		u1.setNotLocked(true);
		userRepo.save(u1);
		userRepo.save(new User("Ahmed","Nasser","nasser@gmail.com","ahmed","ahmed"));
		userRepo.save(new User("Abdul","Aziz","haf@gmail.com","abdul","abdul"));
		
	}

}

package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
@Enable
public class AngularBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularBackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepo;
	@PostConstruct
	public void init() throws Exception {
		
		userRepo.save(new User("Mohd","Hafeez","haf@gmail.com","hafeez","hafeez"));
		userRepo.save(new User("Ahmed","Nasser","nasser@gmail.com","ahmed","ahmed"));
	userRepo.save(new User("Abdul","Aziz","haf@gmail.com","abdul","abdul"));
		
	}

}

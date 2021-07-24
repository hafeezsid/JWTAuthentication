package com.tutor.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
public class EcommerceAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAPIApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	/*
	 * @Autowired private UserRepository userRepo;
	 */
	/*
	 * @PostConstruct public void init() throws Exception { User u1=new
	 * User("Mohd","Hafeez","haf@gmail.com","hafeez","hafeez"); String []a=
	 * {"ROLE_USER"}; u1.setAuthorities(a); u1.setActive(true);
	 * u1.setNotLocked(true); userRepo.save(u1); userRepo.save(new
	 * User("Ahmed","Nasser","nasser@gmail.com","ahmed","ahmed"));
	 * 
	 * User u2=new User("Abdul","Aziz","haf@gmail.com","abdul","abdul"); String []
	 * aa= {"ROLE_ADMIN"}; u2.setAuthorities(aa); u2.setActive(true);
	 * u2.setNotLocked(true); userRepo.save(u2);
	 * 
	 * 
	 * Employee e1=new Employee("Rakesh","Prakash","rake@gmail.com"); Employee
	 * e2=new Employee("Amit","Patel","amitre@gmail.com"); Employee e3=new
	 * Employee("Rahul","Verma","rahil@gmail.com"); Employee e4=new
	 * Employee("Supriya","Khanna","supri@gmail.com"); empRepo.save(e1);
	 * empRepo.save(e2); empRepo.save(e3); empRepo.save(e4);
	 * 
	 * }
	 */

}

package com.ecommerce.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.TokenVerification;
import com.ecommerce.api.entity.User;

@Repository
public interface TokenRepository extends JpaRepository<TokenVerification, Long>{
	List<TokenVerification> findByUser(User user);
	
	List<TokenVerification> findByToken(String token);
	


}

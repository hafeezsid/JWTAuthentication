package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

	@Query(value = "SELECT u FROM users u WHERE u.id = :userId and u.userType = :type")
	public User findByUserIdAndType( @Param("userId")long userId,  @Param("type")String type);
}

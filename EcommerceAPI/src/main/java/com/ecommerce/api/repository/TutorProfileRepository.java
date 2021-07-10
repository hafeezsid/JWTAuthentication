package com.ecommerce.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.TutorProfile;
import com.ecommerce.api.entity.User;

@Repository
public interface TutorProfileRepository extends JpaRepository<TutorProfile, Long> {
	//final String FIND_BY_USER_ID="select * from "
	
	@Query(value = "SELECT * from tutor_profile_mast tp where tp.user_id= :userId"
			,nativeQuery = true)
	TutorProfile findByUser(@Param("userId") long userId);
	
	TutorProfile findByUser(User user);

}

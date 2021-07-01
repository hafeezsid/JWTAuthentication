package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.ProfileImage;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long>{
	
	
}

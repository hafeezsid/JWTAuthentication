package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.entity.ProfileImage;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long>{
	
	
}

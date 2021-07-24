package com.tutor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor.api.entity.ProfileImage;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long>{
	
	
}

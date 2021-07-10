package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.TutorPersonalInfo;
import com.ecommerce.api.entity.UserLanguage;

@Repository
public interface UserLanguaugeRepository extends JpaRepository<UserLanguage, Long>{
	void deleteByTutorPersonalInfo(TutorPersonalInfo obj);
}

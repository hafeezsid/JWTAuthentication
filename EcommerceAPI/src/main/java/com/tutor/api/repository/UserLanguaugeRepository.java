package com.tutor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor.api.entity.TutorPersonalInfo;
import com.tutor.api.entity.UserLanguage;

@Repository
public interface UserLanguaugeRepository extends JpaRepository<UserLanguage, Long>{
	void deleteByTutorPersonalInfo(TutorPersonalInfo obj);
}

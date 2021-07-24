package com.tutor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutor.api.entity.TutorPersonalInfo;

public interface TutorPersonalInfoRepository extends JpaRepository<TutorPersonalInfo, Long> {

}

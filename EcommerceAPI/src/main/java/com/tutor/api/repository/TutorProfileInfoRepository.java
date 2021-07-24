package com.tutor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor.api.entity.TutorProfileInfo;

@Repository
public interface TutorProfileInfoRepository extends JpaRepository<TutorProfileInfo, Long> {

}

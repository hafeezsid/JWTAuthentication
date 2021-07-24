package com.tutor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor.api.entity.TutorPersonalInfo;


@Repository
public interface TutorPersnlInfoRepository extends JpaRepository<TutorPersonalInfo, Long> {

}
